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
	 * Gets the associated {@link Operation} from its symbol.
	 * @param symbol the symbol of the operation
	 * @return operation associated with the symbol
	 */
	public static @Nullable Operation parse(String symbol) {
		return LOOKUP.get(symbol);
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
}
