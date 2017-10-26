package epi2._03strings;

// @see https://introcs.cs.princeton.edu/java/61data/Converter.java.html
public class BaseConversionSedgewick {

	static String convert(String s, int base1, int base2) {
		return decimalToOtherBase(otherBaseToDecimal(s, base1), base2);
	}

	static String decimalToOtherBase(String s, int base) {
		return toString(Integer.parseInt(s), base);
	}

	static String otherBaseToDecimal(String s, int base) {
		return toString(Integer.parseInt(s), base);
	}

	static String toString(int n, int base) {
		if (n == 0) {
			return "0";
		}

		boolean negative = n < 0;
		if (negative) {
			n = -n;
		}

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(toChar(n % base));
			n = n / base;
		}

		if (negative) {
			sb.append('-');
		}

		return sb.reverse().toString();
	}
	
    public static int parseInt(String s, int base) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = base*n + toInt(s.charAt(i));
        }
        
        return n;
    }

    public static int toInt(char c) {
        if (c < '0' || c > 'Z') throw new IllegalArgumentException("invalid char");
        if ((c >= '0') && (c <= '9')) return c - '0';
        return c - 'A' + 10;
    }

	public static char toChar(int i) {
		if (i < 0 || i > 36) {
			throw new IllegalArgumentException("invalid digit");
		}
		if (i < 10) {
			return (char) ('0' + i);
		}
		return (char) ('A' + i - 10);
	}

	public static void main(String[] args) {
		for (int i = -4; i < 11; i++) {
			System.out.println(toString(i, 2));
		}

	}

}
