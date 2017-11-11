package epi2._09hashTables;

import java.util.HashMap;
import java.util.Map;

public class IsAnonymousLetterConstructible {
	
	static boolean isConstructible(String letter, String magazine) {
		// build the character counts for the letter
		Map<Character, Integer> letterMap = new HashMap<>();
		for (int i = 0; i < letter.length(); i++) {
			Character c = letter.charAt(i);
			if (letterMap.containsKey(c)) {
				letterMap.put(c, letterMap.get(c) + 1);
			} else {
				letterMap.put(c, 1);
			}
		}
		
		// pass through the magazine, decreasing the letter tally
		for (int i = 0; i < magazine.length(); i++) {
			Character c = magazine.charAt(i);
			Integer count = letterMap.get(c);
			if (count != null) {
				--count;
				if (count > 0) {
					letterMap.put(c, count);
				} else {
					letterMap.remove(c);
				}
			}
		}
		
		// if tally is non-empty, some letters are in insufficient supply from the magazine
		return letterMap.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isConstructible("1234567890", "1234567890"));//true
		System.out.println(isConstructible("890", "800"));//false
		System.out.println(isConstructible("123", "122"));//false
		System.out.println(isConstructible("123", "12"));//false
		System.out.println(isConstructible("123", "1223"));//true
	}

}
