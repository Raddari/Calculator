package me.harvey.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {
    
    @Test
    void applyMinus() {
        var op = Operator.MINUS;
        var x = 10.0;
        var y = 7.0;
        var result = op.applyAsDouble(x, y);
        assertThat(result).isEqualTo(x - y);
    }
    
    @Test
    void applyPlus() {
        var op = Operator.PLUS;
        var x = 10.0;
        var y = 7.0;
        var result = op.applyAsDouble(x, y);
        assertThat(result).isEqualTo(x + y);
    }
    
    @Test
    void applyTimes() {
        var op = Operator.TIMES;
        var x = 10.0;
        var y = 7.0;
        var result = op.applyAsDouble(x, y);
        assertThat(result).isEqualTo(x * y);
    }
    
    @Test
    void applyRemainder() {
        var op = Operator.REMAINDER;
        var x = 10.0;
        var y = 7.0;
        var result = op.applyAsDouble(x, y);
        assertThat(result).isEqualTo(x % y);
    }
    
    @Test
    void applyDivide() {
        var op = Operator.DIVIDE;
        var x = 10.0;
        var y = 7.0;
        var result = op.applyAsDouble(x, y);
        assertThat(result).isEqualTo(x / y);
    }
    
    @Test
    void applyExp() {
        var op = Operator.EXP;
        var x = 10.0;
        var y = 7.0;
        var result = op.applyAsDouble(x, y);
        assertThat(result).isEqualTo(Math.pow(x, y));
    }
    
    @Test
    void parseMinus() {
        var op = Operator.parse("-");
        assertThat(op).isEqualTo(Operator.MINUS);
    }
    
    @Test
    void parsePlus() {
        var op = Operator.parse("+");
        assertThat(op).isEqualTo(Operator.PLUS);
    }
    
    @Test
    void parseTimes() {
        var op = Operator.parse("*");
        assertThat(op).isEqualTo(Operator.TIMES);
    }
    
    @Test
    void parseRemainder() {
        var op = Operator.parse("%");
        assertThat(op).isEqualTo(Operator.REMAINDER);
    }
    
    @Test
    void parseDivide() {
        var op = Operator.parse("/");
        assertThat(op).isEqualTo(Operator.DIVIDE);
    }
    
    @Test
    void parseExp() {
        var op = Operator.parse("^");
        assertThat(op).isEqualTo(Operator.EXP);
    }
    
    @Test
    void parseUnknown() {
        var op = Operator.parse("r");
        assertThat(op).isNull();
    }
    
    @Test
    void parseNull() {
        var op = Operator.parse(null);
        assertThat(op).isNull();
    }
}
