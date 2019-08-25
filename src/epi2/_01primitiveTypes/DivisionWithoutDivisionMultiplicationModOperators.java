package epi2._01primitiveTypes;

/**
 * @see https://discuss.leetcode.com/topic/17600/32-times-bit-shift-operation-in-c-with-o-1-solution
 * @see https://en.wikipedia.org/wiki/Division_algorithm#Integer_division_.28unsigned.29_with_remainder
 */
public class DivisionWithoutDivisionMultiplicationModOperators {

	static int divide(int dividend, int divisor) {

		// 1) short-circuit processing and checking
		if (divisor == 0) {
			throw new ArithmeticException("Division by zero");
		}
		if (divisor > dividend) {
			return 0;
		}
		if (divisor == dividend) {
			return 1;
		}
		if (divisor == 1) {
			return dividend;
		}
		if (divisor == -1) {
			return -dividend;
		}

		// 2) use only non-negative values
		boolean signed = (dividend > 0) ^ (divisor > 0);
		if (divisor < 0) {
			divisor = -divisor;
		}
		if (dividend < 0) {
			dividend = -dividend;
		}

		// 3) start with highest set bit, to prevent unnecessary processing
		// skip once because of the sign bit
		// skip again to not shift everything to 0
		int start = 32 - 2;
		while ((dividend >>> start) == 0) {
			start--;
		}
		
		// 4) algorithm from wikipedia
		int quotient = 0;
		int remainder = 0;
		int bit = 0;
		for (int i = start; i > -1; i--) { // number of bits in positive word - 1
			remainder <<= 1;
			bit = (dividend >>> i) & 1; // get the bit i of the dividend
			remainder |= bit; // set the retrieved bit to the least significant bit of remainder
			
			if (remainder >= divisor) {
				remainder -= divisor;
				quotient |= 1 << i; // set the ith bit of the quotient to 1
			}
		}

		// 5) return with correct sign
		return signed ? -quotient : quotient;
	}

	static long divide(long dividend, long divisor) {

		// 1) short-circuit processing and checking
		if (divisor == 0) {
			throw new ArithmeticException("Division by zero");
		}
		if (divisor > dividend) {
			return 0;
		}
		if (divisor == dividend) {
			return 1;
		}
		if (divisor == 1) {
			return dividend;
		}
		if (divisor == -1) {
			return -dividend;
		}

		// 2) use only positive values
		boolean signed = (dividend > 0L) ^ (divisor > 0L);
		if (divisor < 0L) {
			divisor = -divisor;
		}
		if (dividend < 0L) {
			dividend = -dividend;
		}

		// 3) start with highest set bit, to prevent unnecessary processing
		// skip once because of the sign bit
		// skip again to not shift everything to 0
		long start = 64L - 2L;
		while ((dividend >>> start) == 0L) {
			start--;
		}
		
		// 4) algorithm from wikipedia
		long quotient = 0L;
		long remainder = 0L;
		long bit = 0L;
		for (long i = start; i > -1L; i--) { // number of bits in positive word - 1
			remainder <<= 1L;
			bit = (dividend >>> i) & 1L; // get the bit i of the dividend
			remainder |= bit; // set the retrieved bit to the least significant bit of remainder
			
			if (remainder >= divisor) {
				remainder -= divisor;
				quotient |= 1L << i; // set the ith bit of the quotient to 1
			}
		}

		// 4) return with correct sign
		return signed ? -quotient : quotient;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < Integer.MAX_VALUE / 100; i++) {
			divide(Integer.MAX_VALUE, 1L);
		}
		System.out.println(System.currentTimeMillis() - start + "ms");
		start = System.currentTimeMillis();
		for (int i = 0; i < Integer.MAX_VALUE / 100; i++) {
			divide(Integer.MAX_VALUE, 1);
		}
		System.out.println(System.currentTimeMillis() - start + "ms");
		
		System.out.println(divide(1, 10));// 0
		System.out.println(divide(1, 1));// 1
		System.out.println(divide(1, -1));// -1
		System.out.println(divide(5, 2));// 2
		System.out.println(divide(18, 3));// 6
		System.out.println(divide(Integer.MAX_VALUE, 1));// Integer.MAX_VALUE
		try {
			System.out.println(divide(1, 0));// exception
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		

		System.out.println(divide(1L, 10L));// 0
		System.out.println(divide(1L, 1L));// 1
		System.out.println(divide(1L, -1L));// -1
		System.out.println(divide(5L, 2L));// 2
		System.out.println(divide(18L, 3L));// 6
		System.out.println(divide(Integer.MAX_VALUE, 1));// Integer.MAX_VALUE
		try {
			System.out.println(divide(1L, 0L));// exception
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}

	}

}
