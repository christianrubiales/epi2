package epi2._03strings;

// @see https://introcs.cs.princeton.edu/java/61data/Converter.java.html
public class BaseConversionSedgewick {

	static String convert(String s, int base1, int base2) {
		return intToString(stringToInt(s, base1), base2);
	}
	
    static int stringToInt(String s, int base) {
		boolean negative = s.charAt(0) == '-';
		
        int x = 0;
        for (int i = negative ? 1 : 0; i < s.length(); i++) {
            x = x*base + toInt(s.charAt(i));
        }
        
        return negative ? -x : x;
    }

    static int toInt(char c) {
        if (c < '0' || c > 'Z') {
        		throw new IllegalArgumentException("invalid char");
        }
        if ((c >= '0') && (c <= '9')) {
        		return c - '0';
        }
        return c - 'A' + 10;
    }

	static String intToString(int x, int base) {
		if (x == 0) {
			return "0";
		}

		boolean negative = x < 0;
		StringBuilder sb = new StringBuilder();
		
		while (x != 0) {
			int digit = x % base;
			sb.append(toChar(negative ? -digit : digit));
			x = x / base;
		}

		if (negative) {
			sb.append('-');
		}

		return sb.reverse().toString();
	}

	static char toChar(int i) {
		if (i < 0 || i > 36) {
			throw new IllegalArgumentException("invalid digit");
		}
		if (i < 10) {
			return (char) ('0' + i);
		}
		return (char) ('A' + i - 10);
	}

	public static void main(String[] args) {
		System.out.println(intToString(Integer.MIN_VALUE, 10));
		for (int i = -4; i < 11; i++) {
			System.out.println(intToString(i, 2));
		}
		
		for (int i = 30; i < 40; i++) {
			System.out.println(intToString(i, 36));
		}
		System.out.println();

		System.out.println(stringToInt("" + Integer.MIN_VALUE, 10));
		System.out.println(stringToInt("-100", 2));
		System.out.println(stringToInt("-11", 2));
		System.out.println(stringToInt("-10", 2));
		System.out.println(stringToInt("-1", 2));
		System.out.println(stringToInt("0", 2));
		System.out.println(stringToInt("1", 2));
		System.out.println(stringToInt("10", 2));
		System.out.println(stringToInt("11", 2));
		System.out.println(stringToInt("100", 2));
		System.out.println(stringToInt("101", 2));
		System.out.println(stringToInt("110", 2));
		System.out.println(stringToInt("111", 2));
		System.out.println(stringToInt("1000", 2));
		System.out.println(stringToInt("1001", 2));
		System.out.println(stringToInt("1010", 2));

		System.out.println(stringToInt("U", 36));
		System.out.println(stringToInt("V", 36));
		System.out.println(stringToInt("W", 36));
		System.out.println(stringToInt("X", 36));
		System.out.println(stringToInt("Y", 36));
		System.out.println(stringToInt("Z", 36));
		System.out.println(stringToInt("10", 36));
		System.out.println(stringToInt("11", 36));
		System.out.println(stringToInt("12", 36));
		System.out.println(stringToInt("13", 36));
	}

}
