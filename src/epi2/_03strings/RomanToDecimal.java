package epi2._03strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToDecimal {
	
//	static Map<Character, Integer> map = new HashMap<>();
//	
//	static {
//		map.put('I', 1);
//		map.put('V', 5);
//		map.put('X', 10);
//		map.put('L', 50);
//		map.put('C', 100);
//		map.put('D', 500);
//		map.put('M', 1000);
//	}
	
	static int getValue(char c) {
		switch (c) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
		}
		return 0;
	}
	
	static int romanToDecimal(String roman) {
		if (roman == null || roman.isEmpty()) {
			throw new IllegalArgumentException("input must not be null or empty");
		}
		
		int value = getValue(roman.charAt(roman.length() - 1));

		for (int i = roman.length() - 1; i > 0; i--) {
			int left = getValue(roman.charAt(i-1));
			int right = getValue(roman.charAt(i));

			if (left < right) {
				value -= left;
			} else {
				value += left;
			}
		}

		return value;
	}

	public static void main(String[] args) {
		System.out.println(romanToDecimal("I"));
		System.out.println(romanToDecimal("II"));
		System.out.println(romanToDecimal("III"));
		System.out.println(romanToDecimal("IV"));
		System.out.println(romanToDecimal("V"));
		System.out.println(romanToDecimal("VI"));
		System.out.println(romanToDecimal("VII"));
		System.out.println(romanToDecimal("VIII"));
		System.out.println(romanToDecimal("IX"));
		System.out.println(romanToDecimal("X"));
		System.out.println(romanToDecimal("XI"));
		System.out.println(romanToDecimal("XIX"));//19
		System.out.println(romanToDecimal("XLIX"));//49
		System.out.println(romanToDecimal("LVIII"));//58
		System.out.println(romanToDecimal("LXIX"));//69
		System.out.println(romanToDecimal("MCMLXXXI"));//1981
	}

}
