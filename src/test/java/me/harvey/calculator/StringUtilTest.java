package me.harvey.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {
    
    @Test
    void isNumericIntPositive() {
        String num = "24";
        assertThat(StringUtil.isNumeric(num)).isTrue();
    }
    
    @Test
    void isNumericIntNegative() {
        String num = "-24";
        assertThat(StringUtil.isNumeric(num)).isTrue();
    }
    
    @Test
    void isNumericDecPositive() {
        String num = "24.053";
        assertThat(StringUtil.isNumeric(num)).isTrue();
    }
    
    @Test
    void isNumericDecNegative() {
        String num = "-24.053";
        assertThat(StringUtil.isNumeric(num)).isTrue();
    }
    
    @Test
    void isNotNumeric() {
        String num = "abc";
        assertThat(StringUtil.isNumeric(num)).isFalse();
    }
}