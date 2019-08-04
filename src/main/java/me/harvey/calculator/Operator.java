package me.harvey.calculator;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

/**
 * <p>An {@code Operation} is a basic mathematical function that can be found on most standard calculators.
 * These operations are specifically binary operators - they require two numbers to operate.
 */
public enum Operator implements DoubleBinaryOperator {
    PLUS		("+", 0, (x, y) -> x + y, Association.LEFT),
	MINUS		("-", 0, (x, y) -> x - y, Association.LEFT),
	TIMES		("*", 1, (x, y) -> x * y, Association.LEFT),
    DIVIDE		("/", 1, (x, y) -> x / y, Association.LEFT),
	REMAINDER	("%", 1, (x, y) -> x % y, Association.LEFT),
	EXP			("^", 2, Math::pow, Association.RIGHT);
	
	/** String representation of the operator */
	private final @NotNull String symbol;
	/** Operator precedence */
	private final int precedence;
	/** Operation to perform */
	private final @NotNull DoubleBinaryOperator op;
	/** Associativity of the operation */
	private final @NotNull Association association;
	
	Operator(@NotNull String symbol, int precedence, @NotNull DoubleBinaryOperator op, @NotNull Association association) {
		this.symbol = symbol;
		this.precedence = precedence;
		this.op = op;
		this.association = association;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double applyAsDouble(double x, double y) {
		return op.applyAsDouble(x, y);
	}
	
	/**
	 * Tests if this operator has a higher precedence.
	 * @param operator operator to compare to
	 * @return {@code true} if this operator has higher precedence
	 */
	public boolean isHigherPrecedence(@NotNull Operator operator) {
	    return this.precedence > operator.precedence;
    }
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return symbol;
	}
	
	/**
	 * Gets the association.
	 * @return the operation's Associativity
	 */
	public @NotNull Association getAssociation() {
		return association;
	}
	
	/**
	 * Gets the associated {@link Operator} from its symbol.
	 * @param symbol the symbol of the operation
	 * @return operation associated with the symbol
	 */
	public static @Nullable Operator parse(@Nullable String symbol) {
		return LOOKUP.get(symbol);
	}
	
	/**
	 * Tests if the given String maps to an Operation.
	 * @param op the operator
	 * @return {@code true} if the enum contains the operation
	 */
	public static boolean isOperator(@NotNull String op) {
		return LOOKUP.containsKey(op);
	}
	
	/**
	 * Static lookup to efficiently get the operation from a string in {@link #parse(String)}.
	 */
	private static final @NotNull Map<String, Operator> LOOKUP = new HashMap<>(values().length);
	static {
		for (Operator operator : values()) {
			LOOKUP.put(operator.symbol, operator);
		}
	}
	
	/**
	 * Defines an Operation as being left-associative or right-associative
	 */
	public enum Association {
		LEFT, RIGHT
	}
}
