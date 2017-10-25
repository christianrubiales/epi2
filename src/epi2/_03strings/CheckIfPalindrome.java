package epi2._03strings;

public class CheckIfPalindrome {
	
	static boolean isPalindrome(String s) {
		
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(""));//true
		System.out.println(isPalindrome("a"));//true
		System.out.println(isPalindrome("aa"));//true
		System.out.println(isPalindrome("aba"));//true
		System.out.println(isPalindrome("ab"));//false
		System.out.println(isPalindrome("abb"));//false

	}

}
