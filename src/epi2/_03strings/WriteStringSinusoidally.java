package epi2._03strings;

public class WriteStringSinusoidally {
	
	static String writeSinusoidally(String s) {
		if (s == null) {
			throw new IllegalArgumentException("Input must not be null");
		}
		
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < s.length(); i += 4) {// s[1],s[5],s[9]...
			builder.append(s.charAt(i));
		}
		for (int i = 0; i < s.length(); i += 2) {// s[0],s[2],s[4]...
			builder.append(s.charAt(i));
		}
		for (int i = 3; i < s.length(); i += 4) {// s[3],s[7],s[11]...
			builder.append(s.charAt(i));
		}
		
		return builder.toString();
	}

	public static void main(String[] args) {
		System.out.println(writeSinusoidally("Hello World!"));//e lHloWrdlo!

	}

}
