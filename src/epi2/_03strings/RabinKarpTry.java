package epi2._03strings;

// FIXME
// TRY https://github.com/mission-peace/interview/blob/master/src/com/interview/string/RabinKarpSearch.java
public class RabinKarpTry {
	
	// start with low value like 3
	// replace with large value later
	static final int PRIME = 3;
	
	static int indexOf(String text, String substring) {
		if (substring.length() > text.length()) {
			return -1;
		}
		
		int substringHash = getHash(substring, 0, substring.length()-1);
		int hash = substring.length() > 1 ? getHash(text, 0, substring.length()-2) : 0;
		
		for (int i = substring.length() - 1; i < text.length(); i++) {
			hash = hash * PRIME + text.charAt(i);
			if (hash == substringHash) {
				// Monte Carlo method: just return index. O(n)
				// Las Vegas method: check if equal. Average O(n+m), worst case O(nm)
				int matches = 0;
				for (int j = 0; j < substring.length(); j++) {
					if (text.charAt(i + j) != substring.charAt(j)) {
						break;
					}
				}
				if (matches == substring.length()) {
					return i;
				}
			}
			hash = subtractFirstHash(hash, substring.length() - 1, text.charAt(substring.length() - i));
		}
		
		return -1;
	}
	
	// inclusive
	static int getHash(String text, int start, int end) {
		int hash = 0;
		
		for (int i = 0; i < end - start + 1; i++) {
			hash += (text.charAt(end - i)) * ((int) Math.pow(PRIME, i));
		}
		
		return hash;
	}

	static int subtractFirstHash(int hash, int power, char first) {
		return hash = hash - ((int) Math.pow(PRIME, power)) * first;
	}

	static int getNextHash(int hash, int power, char first, char last) {
		hash = hash - ((int) Math.pow(PRIME, power)) * first; // remove first part
		return hash + PRIME * last; // add last char
	}

	public static void main(String[] args) {
		getHash("b", 0, 0);
		getHash("abeda", 0, 2);
		System.out.println(indexOf("ab", "b"));//1
		System.out.println(indexOf("aaaaaaaaaab", "b"));//10
		System.out.println(indexOf("0123456789", "0123456789"));//0
		System.out.println(indexOf("0123456789", "abc"));//-1
		System.out.println(indexOf("0123456789", "456"));//4
		System.out.println(indexOf("The quick brown fox", "quick"));//4

	}

}
