package epi2._01primitiveTypes;

/**
 * @see https://discuss.leetcode.com/topic/17600/32-times-bit-shift-operation-in-c-with-o-1-solution
 * @see https://en.wikipedia.org/wiki/Division_algorithm#Integer_division_.28unsigned.29_with_remainder
 */
public class DivisionWithoutDivisionMultiplicationModOperators {

	static int divide(int dividend, int divisor) {

		// 1) short-circuit processing and checking
		if (divisor > dividend) {
			return 0;
		}
		if (divisor == dividend) {
			return 1;
		}
		if (divisor == 0) {
			throw new ArithmeticException("Division by zero");
		}

		// 2) handle negatives
		boolean signed = (dividend > 0) ^ (divisor > 0);
		if (divisor < 0) {
			divisor = -divisor;
		}
		if (dividend < 0) {
			dividend = -dividend;
		}

		// 3) shift 31 times
		int quotient = 0;
		int remainder = 0;
		int bit = 0;
		
		for (int i = 31 - 1; i > -1; i--) { // number of bits in positive word - 1
			remainder <<= 1;
			bit = (dividend >>> i) & 1; // get the bit i of the dividend
			remainder |= bit; // set the retrieved bit to the least significant bit of remainder
			
			if (remainder >= divisor) {
				remainder -= divisor;
				quotient |= 1 << i; // set the ith bit of the quotient to 1
			}
		}

		// 4) return with correct sign
		return signed ? -quotient : quotient;
	}

	static long divide(long dividend, long divisor) {

		// 1) short-circuit processing and checking
		if (divisor > dividend) {
			return 0;
		}
		if (divisor == dividend) {
			return 1;
		}
		if (divisor == 0) {
			throw new ArithmeticException("Division by zero");
		}

		// 2) handle negatives
		boolean signed = (dividend > 0) ^ (divisor > 0);
		if (divisor < 0) {
			divisor = -divisor;
		}
		if (dividend < 0) {
			dividend = -dividend;
		}

		// 3) shift 62 times
		long quotient = 0;
		long remainder = 0;
		long bit = 0;
		
		for (int i = 63 - 1; i > -1; i--) { // number of bits in positive word - 1
			remainder <<= 1;
			bit = (dividend >>> i) & 1; // get the bit i of the dividend
			remainder |= bit; // set the retrieved bit to the least significant bit of remainder
			
			if (remainder >= divisor) {
				remainder -= divisor;
				quotient |= 1 << i; // set the ith bit of the quotient to 1
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
		System.out.println(divide(1, 0));// exception

	}

}
