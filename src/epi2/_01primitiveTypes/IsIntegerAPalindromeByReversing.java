package epi2._01primitiveTypes;

// Significantly faster than digit by digit comparison in my tests
public class IsIntegerAPalindromeByReversing {
	
	static boolean isPalindrome(int x) {
		// negatives can't be palindromes because of the leading sign
		if (x < 0) {
			return false;
		}
		
		int reversed = 0;
		int remaining = x;
		
		while (remaining != 0) {
			reversed = reversed * 10 + remaining % 10;
			remaining /= 10;
		}
		
		return x == reversed;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(-1));// false
		System.out.println(isPalindrome(12));// false
		System.out.println(isPalindrome(1234567890));// false
		System.out.println(isPalindrome(0));// true
		System.out.println(isPalindrome(1));// true
		System.out.println(isPalindrome(11));// true
		System.out.println(isPalindrome(121));// true
		System.out.println(isPalindrome(333));// true

		long start = System.currentTimeMillis();
		for (int i = 0; i < Integer.MAX_VALUE / 100; i++) {
			isPalindrome(i);
		}
		System.out.println(System.currentTimeMillis() - start + "ms");
		
		long pal = 0;
		start = System.currentTimeMillis();
		for (int i = 0; i < Integer.MAX_VALUE / 10; i++) {
			pal += isPalindrome(i) ? 1 : 0;
		}
		System.out.println(System.currentTimeMillis() - start + "ms");
		System.out.println(pal);
	}

}
