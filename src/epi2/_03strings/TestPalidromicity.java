package epi2._03strings;

public class TestPalidromicity {
	
	static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int i = 0;
		int j = s.length() - 1;
		
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal, Panama!"));//true
		System.out.println(isPalindrome("Able was I, ere I saw Elba!"));//true
		System.out.println(isPalindrome("Ray a Ray"));//false
	}

}
