package epi2._01primitiveTypes;

public class MultiplyWithoutArithmeticOperators {
	
	// iterate through the bits of x, adding (2^k)*y to result if kth bit is 1
	// (2^k)*y can be computed by left-shifting y by k
	// O(n^2) - n additions, each addition is O(n) - where n is width of operands
	static long multiply(long x, long y) {
		long sum = 0;
		
		// handle negative inputs
		// otherwise, would not work if x is negative
		if (x < 0) {
			if (y < 0) {
				x = -x;
				y = -y;
			} else {
				long t = x;
				x = y;
				y = t;
			}
		}
		
		while (x != 0) {
			if ((x & 1) == 1) {
				sum = add(sum, y);
			}
			x >>= 1;
			y <<= 1;
		}
		
		return sum;
	}
	
	// O(n) - where n is width of operands
	static long add(long x, long y) {
		while (y != 0) {
			long carry = x & y;
			x = x ^ y; // sum
			y = carry << 1L;
		}
		
		return x;
	}

	public static void main(String[] args) {
		System.out.println(multiply(0, 0));//0
		System.out.println(multiply(0, 1));//0
		System.out.println(multiply(1, 0));//0
		System.out.println(multiply(1, 2));//2
		System.out.println(multiply(2, 1));//2
		System.out.println(multiply(2, -1));//-2
		System.out.println(multiply(1, -2));//-2
		System.out.println(multiply(-1, 2));//-2
		System.out.println(multiply(-1, -2));//2
		System.out.println(multiply(2, Integer.MAX_VALUE));//4294967294
	}

}
