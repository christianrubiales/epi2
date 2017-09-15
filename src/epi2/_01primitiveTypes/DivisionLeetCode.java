package epi2._01primitiveTypes;

/**
 * @see https://discuss.leetcode.com/topic/17600/32-times-bit-shift-operation-in-c-with-o-1-solution
 * @see https://en.wikipedia.org/wiki/Division_algorithm#Integer_division_.28unsigned.29_with_remainder
 */
public class DivisionLeetCode {

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

		// 3) shift 32 times
		int result = 0;
		for (int i = 31; i > -1; i--) {
			if ((dividend >>> i) >= divisor) {
				result = (result << 1) | 1;
				dividend -= divisor << i;
			} else {
				result <<= 1;
			}
		}

		// 4) return with correct sign
		return signed ? -result : result;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
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
