package epi2._01primitiveTypes;

/**
 * 1 if number of 1s is odd, else 0
 */
public class ParityOfWord {
	
	// similar to counting bits but uses xor instead of incrementing
	// n & 1 equals either 1 or 0 (checks if lowest bit is 1)
	// O(n), n is number of bits
	static short parityBitByBit(long n) {
		short parity = 0;
		
		while (n != 0) {
			parity ^= n & 1; // flip parity
			n >>>= 1; // shift
		}
		
		return parity;
	}
	
	// O(k), k is number of set bits, instead of all bits
	static short parityByClearingLowestBit(long n) {
		short parity = 0;
		
		while (n != 0) {
			parity ^= 1; // flip parity
			n &= n-1; // clear lowest bit
		}
		
		return parity;
	}
	
	// n xor with the right shifted n, the last bit is the parity so use n & 1
	// Build case using 2 bits first
	// O(logn)
	static short parityByXor(long n) {
		n ^= n >>> 32;
		n ^= n >>> 16;
		n ^= n >>> 8;
		n ^= n >>> 4;
		n ^= n >>> 2;
		n ^= n >>> 1;

		return (short) (n & 1);
	}

	public static void main(String[] args) {
		System.out.println(parityBitByBit(0b1010));//0
		System.out.println(parityBitByBit(0b1011));//1

		System.out.println(parityByClearingLowestBit(0b1010));//0
		System.out.println(parityByClearingLowestBit(0b1011));//1

		System.out.println(parityByXor(0b1010));//0
		System.out.println(parityByXor(0b1011));//1
	}

}
