package epi2._01primitiveTypes;

public class CountBits {
	
	// n & 1 equals either 1 or 0
	// O(n), n is number of bits
	static short countBits(int n) {
		short bits = 0;
		
		while (n != 0) {
			bits += n & 1;
			n >>>= 1;
		}
		
		return bits;
	}
	
	// O(k), k is the number of 1 bits, not all the bits
	static short countBitsByClearingLowestBit(int n) {
		short bits = 0;
		
		while (n != 0) {
			bits++;
			n &= n-1;
		}
		
		return bits;
	}

	public static void main(String[] args) {
		System.out.println(countBits(12));//2
		System.out.println(countBits(7));//3

		System.out.println(countBitsByClearingLowestBit(12));//2
		System.out.println(countBitsByClearingLowestBit(7));//3
	}

}
