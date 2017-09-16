package epi2._01primitiveTypes;

public class ExtractLowestSetBit {
	
	// returns the binary representation of the word containing a single bit
	// where the set bit is the lowest set bit in the original word
	static int lowestSetBit(int x) {
		return x & ~(x-1);
	}

	public static void main(String[] args) {
		System.out.println(lowestSetBit(0b1));//1
		System.out.println(lowestSetBit(0b11));//1
		System.out.println(lowestSetBit(0b111));//1
		
		System.out.println(lowestSetBit(0b110));//2
		System.out.println(lowestSetBit(0b1010));//2
		
		System.out.println(lowestSetBit(0b10));//2
		System.out.println(lowestSetBit(0b100));//4
		System.out.println(lowestSetBit(0b1000));//8
		System.out.println(lowestSetBit(0b10000));//16
		
		System.out.println(lowestSetBit(0b110));//2
		System.out.println(lowestSetBit(0b1100));//4
		System.out.println(lowestSetBit(0b11000));//8
		System.out.println(lowestSetBit(0b110000));//16
	}

}
