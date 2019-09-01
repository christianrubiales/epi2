package epi2._03strings;

import java.util.ArrayList;
import java.util.List;

public class WriteStringSinusoidallyTry {
	
	static String writeSinusoidally(String s) {
		
		List<Character> s1 = new ArrayList<>();
		List<Character> s2 = new ArrayList<>();
		List<Character> s3 = new ArrayList<>();
		boolean isUp = true;
		List<Character> current = s2;
		
		for (int i = 0; i < s.length(); i++) {
			current.add(s.charAt(i));
			if (current == s2) {
				if (isUp) {
					current = s1;
				} else {
					current = s3;
				}
			} else  if (current == s1) {
				isUp = false;
				current = s2;
			} else if (current == s3) {
				isUp = true;
				current = s2;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (char c : s1) {
			sb.append(c);
		}
		for (char c : s2) {
			sb.append(c);
		}
		for (char c : s3) {
			sb.append(c);
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(writeSinusoidally("Hello World!"));//e lHloWrdlo!

	}

}
