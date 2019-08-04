package me.harvey.calculator;

import org.jetbrains.annotations.NotNull;

public final class StringUtil {
	
	private StringUtil() {
		// No instances
	}
	
	/**
	 * Checks if a String contains only numeric characters (with optional negative sign and decimal).
	 * This ONLY works for latin numbers 0-9.
	 * @param str the string to check
	 * @return {@code true} if the string comprises of only numbers
	 */
	public static boolean isNumeric(@NotNull String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}
	
}
