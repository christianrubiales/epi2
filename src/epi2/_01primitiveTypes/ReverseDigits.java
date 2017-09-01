package epi2._01primitiveTypes;

public class ReverseDigits {
	
	// build the lower digits by multiplying by 10
	// and decrease the remaining digits by dividing by 10
	static long reverse(long n) {
		long result = 0;
		long remaining = Math.abs(n);
		
		while (remaining != 0) {
			result = result * 10 + remaining % 10;
			remaining /= 10;
		}
		
		
		return n < 0 ? -result : result;
	}

	public static void main(String[] args) {
		System.out.println(reverse(123));
	}

}
