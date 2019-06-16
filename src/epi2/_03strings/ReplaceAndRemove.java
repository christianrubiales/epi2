package epi2._03strings;

public class ReplaceAndRemove {
	
	// O(n) time, O(1) space
	static char[] replaceAndRemove(char[] s) {
		if (s == null) {
			throw new IllegalArgumentException("parameter must not be null");
		}
		
		int aCount = 0;
		int index = 0;
		
		// replace b and count a
		for (int i = 0; i < s.length && s[i] != ' '; i++) {
			if (s[i] != 'b') {
				s[index++] = s[i];
			}
			if (s[i] == 'a') {
				aCount++;
			}
		}
		
		// replace a with dd starting from the end
		int current = index - 1;
		index = index + aCount - 1;
		int finalSize = index + 1;
		
		while (current > -1) {
			if (s[current] == 'a') {
				s[index--] = 'd';
				s[index--] = 'd';
			} else {
				s[index--] = s[current];
			}
			current--;
		}
		
		// remove excess
		for (int i = finalSize; i < s.length; i++) {
			s[i] = ' ';
		}
		
		return s;
	}

	public static void main(String[] args) {
		System.out.println(replaceAndRemove("a ".toCharArray()));//dd
		System.out.println(replaceAndRemove("abac ".toCharArray()));//ddddc
		System.out.println(replaceAndRemove("acaa   ".toCharArray()));//ddcdddd
		System.out.println(replaceAndRemove("ab".toCharArray()));//dd
		System.out.println(replaceAndRemove("b".toCharArray()));//
		System.out.println(replaceAndRemove("bbbb".toCharArray()));//
		System.out.println(replaceAndRemove("ba".toCharArray()));//dd
		System.out.println(replaceAndRemove("acdbbca".toCharArray()));//ddcdcdd
		System.out.println(replaceAndRemove("".toCharArray()));//
		System.out.println(replaceAndRemove(null));
	}

}
