package me.harvey.calculator;

import org.jetbrains.annotations.NotNull;

/**
 * <p>{@code ExpressionParser} is responsible for taking a string, ensuring that it is valid syntax, and offering
 * the tokens in the correct order of operations for calculating.
 */
public final class ExpressionParser {
	
	/** Line to parse */
	private final @NotNull String _expr;
	
	public ExpressionParser(@NotNull String line) {
		_expr = line.trim().toLowerCase();
	}
	
}
