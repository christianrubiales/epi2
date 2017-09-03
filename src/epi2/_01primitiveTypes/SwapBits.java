package epi2._01primitiveTypes;

public class SwapBits {

	// get bits at given positions
	// swap only if bits are different
	static long swapBits(long n, int i, int j) {
		short bi = getBitAt(n, i);
		short bj = getBitAt(n, j);
		
		if (bi != bj) {
			n = setBitAt(n, i, bj);
			n = setBitAt(n, j, bi);
		}
		
		return n;
	}
	
	// shift number i times then logical AND with 1
	static short getBitAt(long n, int i) {
		n >>>= i;
		return (short) (n & 1);
	}

	// set a bit using xor with shifted 1
	static long setBitAt(long n, int i, int b) {
		long mask = 1L << i;
		return n ^ mask;
	}

	// slightly more efficient
	static long swapBitsEPI(long n, int i, int j) {
		
		// get ith and jth bits and check if different
		if (((n >>> i) & 1) != (((n >>> j) & 1))) {
			
			// swap bits by flipping using xor
			// 1^1=0 and 0^1=1
			long mask = (1L << i) | (1L << j);
			n ^= mask;
		}
		return n;
	}

	public static void main(String[] args) {
		System.out.println(getBitAt(0b101, 0));//1
		System.out.println(getBitAt(0b101, 1));//0
		System.out.println(getBitAt(0b101, 2));//1
		System.out.println();
		
		System.out.println(setBitAt(0b101, 0, 0));//4
		System.out.println(setBitAt(0b101, 1, 1));//7
		System.out.println(setBitAt(0b0, 16, 1));//65536
		System.out.println(setBitAt(0b0, 32, 1));//4294967296
		System.out.println(setBitAt(0b0, 62, 1));//4611686018427387904
		System.out.println(setBitAt(4611686018427387904L, 62, 0));//0
		System.out.println(setBitAt(65536, 16, 0));//0
		System.out.println();
		
		System.out.println(swapBits(0b101, 0, 1));//6
		System.out.println(swapBits(0b101, 1, 2));//3
		System.out.println();
		
		System.out.println(swapBitsEPI(0b101, 0, 1));//6
		System.out.println(swapBitsEPI(0b101, 1, 2));//3
	}

}
