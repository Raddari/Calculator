package me.harvey.calculator;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

/**
 * <p>An {@code Operation} is a basic mathematical function that can be found on most standard calculators.
 * These operations are specifically binary operators - they require two numbers to operate.
 *
 * <p>Operations are in reverse order in accordance to BEDMAS - this is to assist with the correct order of
 * operations.
 *
 * <p>TODO: Unary operators
 */
public enum Operation {
	SUBTRACT	("-", (x, y) -> x - y, Association.LEFT),
	ADD			("+", (x, y) -> x + y, Association.LEFT),
	MULTIPLY	("*", (x, y) -> x * y, Association.LEFT),
	MODULO		("%", (x, y) -> x % y, Association.LEFT),
	DIVIDE		("/", (x, y) -> x / y, Association.LEFT),
	POWER		("^", (x, y) -> Math.pow(x, y), Association.RIGHT);
	
	/** String representation of the operator */
	private final @NotNull String _symbol;
	/** Operation to perform */
	private final @NotNull DoubleBinaryOperator _op;
	/** Associativity of the operation */
	private final @NotNull Association _association;
	
	Operation(@NotNull String symbol, @NotNull DoubleBinaryOperator op, @NotNull Association association) {
		_symbol = symbol;
		_op = op;
		_association = association;
	}
	
	/**
	 * Apply the operation to the given doubles.
	 * @param x left double
	 * @param y right double
	 * @return the result of the operation on the two doubles
	 */
	public double apply(double x, double y) {
		return _op.applyAsDouble(x, y);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return _symbol;
	}
	
	/**
	 * Gets the association.
	 * @return the operation's Associativity
	 */
	public @NotNull Association getAssociation() {
		return _association;
	}
	
	/**
	 * Gets the associated {@link Operation} from its symbol.
	 * @param symbol the symbol of the operation
	 * @return operation associated with the symbol
	 */
	public static @Nullable Operation parse(@Nullable String symbol) {
		return LOOKUP.get(symbol);
	}
	
	/**
	 * Tests if the given String maps to an Operation.
	 * @param op the operator
	 * @return {@code true} if the enum contains the operation
	 */
	public static boolean isOperation(@NotNull String op) {
		return LOOKUP.containsKey(op);
	}
	
	/**
	 * Static lookup to efficiently get the operation from a string in {@link #parse(String)}.
	 */
	private static final @NotNull Map<String, Operation> LOOKUP = new HashMap<>(values().length);
	static {
		for (Operation operation : values()) {
			LOOKUP.put(operation._symbol, operation);
		}
	}
	
	/**
	 * Defines an Operation as being left-associative or right-associative
	 */
	public enum Association {
		LEFT, RIGHT
	}
}
