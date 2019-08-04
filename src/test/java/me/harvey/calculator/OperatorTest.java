package me.harvey.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {
    
    @Test
    void applyMinus() {
        Operator op = Operator.MINUS;
        double x = 10;
        double y = 7;
        double result = op.applyAsDouble(x, y);
        assertThat(result).isEqualTo(x - y);
    }
    
    @Test
    void applyPlus() {
        Operator op = Operator.PLUS;
        double x = 10;
        double y = 7;
        double result = op.applyAsDouble(x, y);
        assertThat(result).isEqualTo(x + y);
    }
    
    @Test
    void applyTimes() {
        Operator op = Operator.TIMES;
        double x = 10;
        double y = 7;
        double result = op.applyAsDouble(x, y);
        assertThat(result).isEqualTo(x * y);
    }
    
    @Test
    void applyRemainder() {
        Operator op = Operator.REMAINDER;
        double x = 10;
        double y = 7;
        double result = op.applyAsDouble(x, y);
        assertThat(result).isEqualTo(x % y);
    }
    
    @Test
    void applyDivide() {
        Operator op = Operator.DIVIDE;
        double x = 10;
        double y = 7;
        double result = op.applyAsDouble(x, y);
        assertThat(result).isEqualTo(x / y);
    }
    
    @Test
    void applyExp() {
        Operator op = Operator.EXP;
        double x = 10;
        double y = 7;
        double result = op.applyAsDouble(x, y);
        assertThat(result).isEqualTo(Math.pow(x, y));
    }
    
    @Test
    void parseMinus() {
        Operator op = Operator.parse("-");
        assertThat(op).isEqualTo(Operator.MINUS);
    }
    
    @Test
    void parsePlus() {
        Operator op = Operator.parse("+");
        assertThat(op).isEqualTo(Operator.PLUS);
    }
    
    @Test
    void parseTimes() {
        Operator op = Operator.parse("*");
        assertThat(op).isEqualTo(Operator.TIMES);
    }
    
    @Test
    void parseRemainder() {
        Operator op = Operator.parse("%");
        assertThat(op).isEqualTo(Operator.REMAINDER);
    }
    
    @Test
    void parseDivide() {
        Operator op = Operator.parse("/");
        assertThat(op).isEqualTo(Operator.DIVIDE);
    }
    
    @Test
    void parseExp() {
        Operator op = Operator.parse("^");
        assertThat(op).isEqualTo(Operator.EXP);
    }
    
    @Test
    void parseUnknown() {
        Operator op = Operator.parse("r");
        assertThat(op).isNull();
    }
}
