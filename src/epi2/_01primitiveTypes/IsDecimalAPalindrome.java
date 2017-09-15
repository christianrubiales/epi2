package epi2._01primitiveTypes;

public class IsDecimalAPalindrome {
	
	static boolean isPalindrome(int x) {
		// negatives can't be palindromes because of the leading sign
		if (x < 0) {
			return false;
		}
		
		int digits = (int) Math.floor(Math.log10(x)) + 1;
		int places = (int) Math.pow(10, digits - 1);
		
		for (int i = 0; i < digits / 2; i++) {
			if (x / places != x % 10) {// compare first and last digits
				return false;
			}
			
			x %= places; // remove first digit
			x /= 10; // remove last digit
			places /= 100; // adjust number of places
		}
		
		return true;
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
		
		start = System.currentTimeMillis();
		for (int i = 0; i < Integer.MAX_VALUE / 100; i++) {
			isPalindrome(i);
		}
		System.out.println(System.currentTimeMillis() - start + "ms");
	}

}
