package me.harvey.calculator;

import org.jetbrains.annotations.NotNull;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
	SUBTRACT	("-", (x, y) -> x - y),
	ADD			("+", (x, y) -> x + y),
	MULTIPLY	("*", (x, y) -> x * y),
	MODULO		("%", (x, y) -> x % y),
	DIVIDE		("/", (x, y) -> x / y),
	POWER		("^", (x, y) -> Math.pow(x, y));
	
	private final @NotNull String _symbol;
	private final @NotNull DoubleBinaryOperator _op;
	
	Operation(@NotNull String symbol, @NotNull DoubleBinaryOperator op) {
		_symbol = symbol;
		_op = op;
	}
}
