package me.harvey.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {
    
    @Test
    void isNumericIntPositive() {
        var num = "24";
        assertThat(StringUtil.isNumeric(num)).isTrue();
    }
    
    @Test
    void isNumericIntNegative() {
        var num = "-24";
        assertThat(StringUtil.isNumeric(num)).isTrue();
    }
    
    @Test
    void isNumericDecPositive() {
        var num = "24.053";
        assertThat(StringUtil.isNumeric(num)).isTrue();
    }
    
    @Test
    void isNumericDecNegative() {
        var num = "-24.053";
        assertThat(StringUtil.isNumeric(num)).isTrue();
    }
    
    @Test
    void isNotNumeric() {
        var num = "abc";
        assertThat(StringUtil.isNumeric(num)).isFalse();
    }
}