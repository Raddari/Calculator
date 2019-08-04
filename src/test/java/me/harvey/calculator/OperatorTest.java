package me.harvey.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class OperatorTest {
	
	@Test
	public void applySubtract() {
		Operator op = Operator.SUBTRACT;
		double x = 10;
		double y = 7;
		double result = op.applyAsDouble(x, y);
		assertThat(result, is(x - y));
	}
	
	@Test
	public void applyAdd() {
		Operator op = Operator.ADD;
		double x = 10;
		double y = 7;
		double result = op.applyAsDouble(x, y);
		assertThat(result, is(x + y));
	}
	
	@Test
	public void applyMultiply() {
		Operator op = Operator.MULTIPLY;
		double x = 10;
		double y = 7;
		double result = op.applyAsDouble(x, y);
		assertThat(result, is(x * y));
	}
	
	@Test
	public void applyModulo() {
		Operator op = Operator.MODULO;
		double x = 10;
		double y = 7;
		double result = op.applyAsDouble(x, y);
		assertThat(result, is(x % y));
	}
	
	@Test
	public void applyDivide() {
		Operator op = Operator.DIVIDE;
		double x = 10;
		double y = 7;
		double result = op.applyAsDouble(x, y);
		assertThat(result, is(x / y));
	}
	
	@Test
	public void applyPower() {
		Operator op = Operator.POWER;
		double x = 10;
		double y = 7;
		double result = op.applyAsDouble(x, y);
		assertThat(result, is(Math.pow(x, y)));
	}
	
	@Test
	public void parseSubtract() {
		Operator op = Operator.parse("-");
		assertThat(op, is(Operator.SUBTRACT));
	}
	
	@Test
	public void parseAdd() {
		Operator op = Operator.parse("+");
		assertThat(op, is(Operator.ADD));
	}
	
	@Test
	public void parseMultiply() {
		Operator op = Operator.parse("*");
		assertThat(op, is(Operator.MULTIPLY));
	}
	
	@Test
	public void parseModulo() {
		Operator op = Operator.parse("%");
		assertThat(op, is(Operator.MODULO));
	}
	
	@Test
	public void parseDivide() {
		Operator op = Operator.parse("/");
		assertThat(op, is(Operator.DIVIDE));
	}
	
	@Test
	public void parsePower() {
		Operator op = Operator.parse("^");
		assertThat(op, is(Operator.POWER));
	}
	
	@Test
	public void parseUnknown() {
		Operator op = Operator.parse("r");
		assertNull(op);
	}
}
