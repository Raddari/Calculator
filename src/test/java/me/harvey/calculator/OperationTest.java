package me.harvey.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class OperationTest {
	
	@Test
	public void applySubtract() {
		Operation op = Operation.SUBTRACT;
		double x = 10;
		double y = 7;
		double result = op.apply(x, y);
		assertThat(result, is(x - y));
	}
	
	@Test
	public void applyAdd() {
		Operation op = Operation.ADD;
		double x = 10;
		double y = 7;
		double result = op.apply(x, y);
		assertThat(result, is(x + y));
	}
	
	@Test
	public void applyMultiply() {
		Operation op = Operation.MULTIPLY;
		double x = 10;
		double y = 7;
		double result = op.apply(x, y);
		assertThat(result, is(x * y));
	}
	
	@Test
	public void applyModulo() {
		Operation op = Operation.MODULO;
		double x = 10;
		double y = 7;
		double result = op.apply(x, y);
		assertThat(result, is(x % y));
	}
	
	@Test
	public void applyDivide() {
		Operation op = Operation.DIVIDE;
		double x = 10;
		double y = 7;
		double result = op.apply(x, y);
		assertThat(result, is(x / y));
	}
	
	@Test
	public void applyPower() {
		Operation op = Operation.POWER;
		double x = 10;
		double y = 7;
		double result = op.apply(x, y);
		assertThat(result, is(Math.pow(x, y)));
	}
	
	@Test
	public void parseSubtract() {
		Operation op = Operation.parse("-");
		assertThat(op, is(Operation.SUBTRACT));
	}
	
	@Test
	public void parseAdd() {
		Operation op = Operation.parse("+");
		assertThat(op, is(Operation.ADD));
	}
	
	@Test
	public void parseMultiply() {
		Operation op = Operation.parse("*");
		assertThat(op, is(Operation.MULTIPLY));
	}
	
	@Test
	public void parseModulo() {
		Operation op = Operation.parse("%");
		assertThat(op, is(Operation.MODULO));
	}
	
	@Test
	public void parseDivide() {
		Operation op = Operation.parse("/");
		assertThat(op, is(Operation.DIVIDE));
	}
	
	@Test
	public void parsePower() {
		Operation op = Operation.parse("^");
		assertThat(op, is(Operation.POWER));
	}
	
	@Test
	public void parseUnknown() {
		Operation op = Operation.parse("r");
		assertNull(op);
	}
}
