package epi2._01primitiveTypes;

/**
 * @see https://en.wikipedia.org/wiki/Division_algorithm#Integer_division_.28unsigned.29_with_remainder
 */
public class DivisionWikipedia {
	
	static long divide(long dividend, long divisor) {
		if (divisor == 0) {
			throw new ArithmeticException("Division by zero");
		}
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
		
		return quotient;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < Integer.MAX_VALUE / 1; i++) {
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
