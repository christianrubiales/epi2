package epi2._03strings;

// @see https://www.codewars.com/kata/578bf2d8daa01a4ee8000046/solutions/java
public class RunLengthEncoding {
	
	static String encode(String s) {
		if (s == null || s.isEmpty()) {
			throw new IllegalArgumentException("input must not be null or empty");
		}
		
		StringBuilder builder = new StringBuilder();
		
		char current = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == current) {
				count++;
			} else {
				builder.append(count).append(current);
				current = s.charAt(i);
				count = 1;
			}
		}
		builder.append(count).append(current);
		
		return builder.toString();
	}
	
	static String decode(String s) {
		if (s == null || s.isEmpty()) {
			throw new IllegalArgumentException("input must not be null or empty");
		}
		
		int count = 0;
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if (current >= '0' && current <= '9') {
				count = count * 10 + (current - '0');
				continue;
			}
			for (int j = 0; j < count; j++) {
				builder.append(current);
			}
			count = 0;
		}
		
		return builder.toString();
	}

	public static void main(String[] args) {
		System.out.println(encode("aaaaaaaaaabcccaa"));//10a1b3c2a
		System.out.println(decode("10a1b3c2a"));//10a1b3c2a
	}

}
