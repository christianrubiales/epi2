/**
 * @see http://java.dzone.com/articles/my-favorite-coding-interview 
 * @see http://chase-seibert.github.io/blog/2014/10/10/my-favorite-interview-question.html
 * @see http://ideone.com/8OT10f
 */
public class LimitRepeatedCharacters {
	public static void main(String[] args) {
		System.out.println(limitRepeatedCharacters("aaab", 2).equals("aab"));
		System.out.println(limitRepeatedCharacters("aabb", 1).equals("ab"));
		System.out.println(limitRepeatedCharacters("aabbaa", 1).equals("aba"));
		System.out.println(limitRepeatedCharacters("aaabaaaabbb", 2).equals("aabaabb"));
		System.out.println(limitRepeatedCharacters("", 1).equals(""));
	}

	public static String limitRepeatedCharacters(String string, int limit) {
		String processed = "";
		if (!string.isEmpty()) { 
			// initialize with the first character
			char currentChar = string.charAt(0);
			int matches = 1;
			processed = processed + currentChar;
			// go through the characters of the string one after another
			// starting at the 2nd character
			for (int i = 1; i < string.length(); i++) {
				if (currentChar == string.charAt(i)) {
					// match found 
					matches++;
					// add the same character if we have not yet reached the repetition limit
					if (matches <= limit) {
						processed = processed + string.charAt(i);
					}
				} else {
					// new character encountered
					currentChar = string.charAt(i);
					matches = 1;
					// re-initialize number of matches
					processed = processed + currentChar;
				}
			}
		}
		return processed;
	}
}
