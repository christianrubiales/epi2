package epi2._03strings;

// O(n) using Monte Carlo method (just return when hashes are equal)
// Las Vegas method: check equality when hashes are equal
// O(n+m) average, O(nm) worst case
public class RabinKarp {
	
	// start with low value like 3 to help with checking
	// replace with large value later
	static final int PRIME = 3;
	
	static int indexOf(String text, String substring) {
		if (substring.length() > text.length()) {
			return -1;
		}
		
		int textHash = 0;
		int substringHash = 0;
		int power = 1;
		
		for (int i = 0; i < substring.length(); i++) {
			power = i > 0 ? power * PRIME : 1;
			substringHash = substringHash * PRIME + substring.charAt(i);
			textHash = textHash * PRIME + text.charAt(i);
		}
		
		for (int i = substring.length(); i < text.length(); i++) {
			if (textHash == substringHash) {
				if (matches(text, substring, i - substring.length())) {
					return i - substring.length();
				}
			}

			textHash -= text.charAt(i - substring.length()) * power;
			textHash = textHash * PRIME + text.charAt(i);
		}
		
		if (textHash == substringHash) {
			if (matches(text, substring, text.length() - substring.length())) {
				return text.length() - substring.length();
			}
		}
		
		return -1;
	}
	
	static boolean matches(String text, String substring, int index) {
		for (int j = 0; j < substring.length(); j++) {
			if (substring.charAt(j) != text.charAt(index+j)) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println(indexOf("abc", "b"));//1
		System.out.println(indexOf("ab", "b"));//1
		System.out.println(indexOf("aab", "b"));//2
		System.out.println(indexOf("abc", "a"));//0
		System.out.println(indexOf("aaaaaaaaaab", "b"));//10
		System.out.println(indexOf("0123456789", "0123456789"));//0
		System.out.println(indexOf("0123456789", "abc"));//-1
		System.out.println(indexOf("0123456789", "456"));//4
		System.out.println(indexOf("The quick brown fox", "quick"));//4	

	}

}
