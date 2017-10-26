package epi2._03strings;

public class InterconvertStringsAndIntegers {
	
	static String toString(int x) {
		if (x == 0) {
			return "0";
		}
		
		boolean negative = x < 0;
		StringBuilder sb = new StringBuilder();
		
		while (x != 0) {
			int digit = x % 10;
			sb.append(negative ? -digit : digit);
			x /= 10;
		}
		if (negative) {
			sb.append('-');
		}
		
		return sb.reverse().toString();
	}

	static int toInt(String s) {
		boolean negative = s.charAt(0) == '-';
		
		int x = 0;
		int start = negative ? 1 : 0;
		for (int i = start; i < s.length(); i++) {
			x = x * 10 + (s.charAt(i) - '0');
		}
		
		return negative ? -x : x;
	}
	
	public static void main(String[] args) {
		System.out.println(toString(Integer.MIN_VALUE));
		System.out.println(toString(-1234));
		System.out.println(toString(-1));
		System.out.println(toString(0));
		System.out.println(toString(1));
		System.out.println(toString(1234));
		System.out.println(toString(Integer.MAX_VALUE));
		
		System.out.println(toInt("-2147483648"));
		System.out.println(toInt("-1234"));
		System.out.println(toInt("-1"));
		System.out.println(toInt("0"));
		System.out.println(toInt("1"));
		System.out.println(toInt("1234"));
		System.out.println(toInt("2147483647"));
		
	}

}
