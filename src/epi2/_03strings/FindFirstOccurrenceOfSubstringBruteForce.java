package epi2._03strings;

public class FindFirstOccurrenceOfSubstringBruteForce {
	
	// O(n * m)
	static int indexOf(String text, String substring) {
		if (substring.length() > text.length()) {
			return -1;
		}
		
		for (int i = 0; i < text.length() - substring.length() + 1; i++) {
			boolean found = true;
			for (int j = 0; j < substring.length(); j++) {
				if (text.charAt(i+j) != substring.charAt(j)) {
					found = false;
					break;
				}
			}
			if (found == true) {
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(indexOf("ab", "b"));//1
		System.out.println(indexOf("aaaaaaaaaab", "b"));//10
		System.out.println(indexOf("0123456789", "0123456789"));//0
		System.out.println(indexOf("0123456789", "abc"));//-1
		System.out.println(indexOf("0123456789", "456"));//4
		System.out.println(indexOf("The quick brown fox", "quick"));//4
	}

}
