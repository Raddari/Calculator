package me.harvey.calculator;

import java.util.Scanner;

/**
 * Main class for the calculator. This class is responsible for running the program, and taking input from
 * the user. After that, it parses the input and matches it to functions in {@link Operation} to produce
 * the correct result of the expression.
 */
public final class Calculator{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input;
		do {
			input = sc.nextLine();
		} while (!"q".equals(input));
		
		sc.close();
	}
	
}
