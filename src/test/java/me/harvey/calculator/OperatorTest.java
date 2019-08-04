package me.harvey.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class OperatorTest {
    
    @Test
    public void applySubtract() {
        Operator op = Operator.MINUS;
        double x = 10;
        double y = 7;
        double result = op.applyAsDouble(x, y);
        assertThat(result, is(x - y));
    }
    
    @Test
    public void applyAdd() {
        Operator op = Operator.PLUS;
        double x = 10;
        double y = 7;
        double result = op.applyAsDouble(x, y);
        assertThat(result, is(x + y));
    }
    
    @Test
    public void applyMultiply() {
        Operator op = Operator.TIMES;
        double x = 10;
        double y = 7;
        double result = op.applyAsDouble(x, y);
        assertThat(result, is(x * y));
    }
    
    @Test
    public void applyModulo() {
        Operator op = Operator.REMAINDER;
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
        Operator op = Operator.EXP;
        double x = 10;
        double y = 7;
        double result = op.applyAsDouble(x, y);
        assertThat(result, is(Math.pow(x, y)));
    }
    
    @Test
    public void parseSubtract() {
        Operator op = Operator.parse("-");
        assertThat(op, is(Operator.MINUS));
    }
    
    @Test
    public void parseAdd() {
        Operator op = Operator.parse("+");
        assertThat(op, is(Operator.PLUS));
    }
    
    @Test
    public void parseMultiply() {
        Operator op = Operator.parse("*");
        assertThat(op, is(Operator.TIMES));
    }
    
    @Test
    public void parseModulo() {
        Operator op = Operator.parse("%");
        assertThat(op, is(Operator.REMAINDER));
    }
    
    @Test
    public void parseDivide() {
        Operator op = Operator.parse("/");
        assertThat(op, is(Operator.DIVIDE));
    }
    
    @Test
    public void parsePower() {
        Operator op = Operator.parse("^");
        assertThat(op, is(Operator.EXP));
    }
    
    @Test
    public void parseUnknown() {
        Operator op = Operator.parse("r");
        assertNull(op);
    }
}
