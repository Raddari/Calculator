package me.harvey.calculator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * <p>Main class for the calculator. This class is responsible for running the program, and taking input from
 * the user. After that, it parses the input and matches it to functions in {@link Operator} to produce
 * the correct result of the expression.
 */
public final class Calculator {
    
    public static void main(String[] args) {
        System.out.println("Type the expression to evaluate, or 'q' to quit");
        try (var sc = new Scanner(System.in)) {
            while (true) {
                var input = sc.nextLine();
                if (input.equals("q")) {
                    break;
                }
                var parsed = shuntYardParse(input);
                var result = evaluateExpression(parsed);
                System.out.println(result);
                System.out.println();
            }
        }
        System.exit(0);
    }
    
    private static double evaluateExpression(@NotNull String postfix) {
        Deque<Double> stack = new ArrayDeque<>();
        
        for (var token : postfix.split(" ")) {
            if (Operator.isOperator(token)) {
                var d0 = stack.pop();
                var d1 = stack.pop();
                stack.push(Operator.parse(token).applyAsDouble(d1, d0));
            } else {
                stack.push(Double.valueOf(token));
            }
        }
        // Result is the last thing left in the stack
        return stack.pop();
    }
    
    private static @NotNull String shuntYardParse(@NotNull String infix) {
        var output = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        
        for (var token : infix.split(" ")) {
            if (Operator.isOperator(token)) {
                while (!stack.isEmpty() && isHigherPrecedence(token, stack.peek())) {
                    output.append(stack.pop()).append(" ");
                }
                stack.push(token);
                
            } else if (token.equals("(")) {
                stack.push(token);
                
            } else if (token.equals(")")) {
                while (!stack.peek().equals("(")) {
                    output.append(stack.pop()).append(" ");
                }
                stack.pop();
                
            } else {
                // Must be a digit
                output.append(token).append(" ");
            }
        }
        
        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }
        return output.toString().trim();
    }
    
    private static boolean isHigherPrecedence(@NotNull String op1, @NotNull String op2) {
        if (!(Operator.isOperator(op1) && Operator.isOperator(op2))) {
            return false;
        }
        return Operator.parse(op2).isHigherPrecedence(Operator.parse(op1));
    }
    
}
