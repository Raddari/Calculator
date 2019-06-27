package me.harvey.calculator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilTest {
	
	@Test
	public void isNumericIntPos() {
		String num = "24";
		assertTrue(StringUtil.isNumeric(num));
	}
	
	@Test
	public void isNumericIntNeg() {
		String num = "-24";
		assertTrue(StringUtil.isNumeric(num));
	}
	
	@Test
	public void isNumericDecPos() {
		String num = "24.053";
		assertTrue(StringUtil.isNumeric(num));
	}
	
	@Test
	public void isNumericDecNeg() {
		String num = "-24.053";
		assertTrue(StringUtil.isNumeric(num));
	}
	
	@Test
	public void isNumericNot() {
		String num = "abc";
		assertFalse(StringUtil.isNumeric(num));
	}
}