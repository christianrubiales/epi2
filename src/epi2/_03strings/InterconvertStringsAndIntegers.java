package epi2._03strings;

public class InterconvertStringsAndIntegers {
	
	static String intToString(int x) {
		if (x == 0) {
			return "0";
		}
		
		boolean negative = x < 0;
		StringBuilder sb = new StringBuilder();
		
		while (x != 0) {
			int digit = x % 10;
			sb.append(negative ? -digit : digit);
			x = x / 10;
		}

		if (negative) {
			sb.append('-');
		}

		return sb.reverse().toString();
	}

	static int stringToInt(String s) {
		boolean negative = s.charAt(0) == '-';
		
		int x = 0;
		for (int i = negative ? 1 : 0; i < s.length(); i++) {
			x = x * 10 + (s.charAt(i) - '0');
		}
		
		return negative ? -x : x;
	}
	
	public static void main(String[] args) {
		System.out.println(intToString(Integer.MIN_VALUE));
		System.out.println(intToString(-1234));
		System.out.println(intToString(-1));
		System.out.println(intToString(0));
		System.out.println(intToString(1));
		System.out.println(intToString(1234));
		System.out.println(intToString(Integer.MAX_VALUE));
		
		System.out.println(stringToInt("-2147483648"));
		System.out.println(stringToInt("-1234"));
		System.out.println(stringToInt("-1"));
		System.out.println(stringToInt("0"));
		System.out.println(stringToInt("1"));
		System.out.println(stringToInt("1234"));
		System.out.println(stringToInt("2147483647"));
		
	}

}
