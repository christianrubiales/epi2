package epi2._01primitiveTypes;

public class ReverseDigits {
	
	// build the lower digits by multiplying by 10
	// and decrease the remaining digits by dividing by 10
	// make sure to process the absolute value
	static long reverse(long n) {
		long reversed = 0;
		long remaining = Math.abs(n);
		
		while (remaining != 0) {
			reversed = reversed * 10 + remaining % 10;
			remaining /= 10;
		}
		
		return n < 0 ? -reversed : reversed;
	}

	public static void main(String[] args) {
		System.out.println(reverse(123)); // 321
	}

}
