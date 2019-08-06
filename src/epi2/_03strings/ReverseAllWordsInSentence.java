package epi2._03strings;

public class ReverseAllWordsInSentence {
	
	static String reverse(String sentence) {
		if (sentence == null || sentence.length() == 0) {
			return sentence;
		}
		
		char[] words = sentence.toCharArray();
		int start = 0;
		int end = words.length - 1;
		
		reverse(words, start, end);
		
		for (int i = 0; i < words.length; i++) {
			if (i == words.length - 1 || words[i] == ' ') {
				end = i == words.length - 1 ? i : i-1;
				reverse(words, start, end);
				start = i+1;
			}
		}
		
		return new String(words);
	}
	
	static void reverse(char[] words, int start, int end) {
		while (start < end) {
			char t = words[start];
			words[start] = words[end];
			words[end] = t;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		System.out.println(reverse("RAM is costly"));// costly is RAM
		System.out.println(reverse("Alice likes Bob"));// Bob likes Alice
	}

}
