package me.harvey.calculator;

import org.jetbrains.annotations.NotNull;

import java.util.function.DoubleBinaryOperator;

/**
 * An {@code Operation} is a basic mathematical function that can be found on most standard calculators.
 * These operations are specifically binary operators - they require two numbers to operate.
 *
 * TODO: Unary operators
 */
public enum Operation {
	SUBTRACT	("-", (x, y) -> x - y),
	ADD			("+", (x, y) -> x + y),
	MULTIPLY	("*", (x, y) -> x * y),
	MODULO		("%", (x, y) -> x % y),
	DIVIDE		("/", (x, y) -> x / y),
	POWER		("^", (x, y) -> Math.pow(x, y));
	
	/** String representation of the operator */
	private final @NotNull String _symbol;
	/** Operation to perform */
	private final @NotNull DoubleBinaryOperator _op;
	
	Operation(@NotNull String symbol, @NotNull DoubleBinaryOperator op) {
		_symbol = symbol;
		_op = op;
	}
}
