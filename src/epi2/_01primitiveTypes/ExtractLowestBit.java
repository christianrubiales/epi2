package epi2._01primitiveTypes;

public class ExtractLowestBit {
	
	// returns the binary representation of the word containing a single bit
	// where the set bit is the lowest set bit in the original word
	static int extractLowestBit(int x) {
		return x & ~(x-1);
	}

	public static void main(String[] args) {
		System.out.println(extractLowestBit(0b1));//1
		System.out.println(extractLowestBit(0b11));//1
		System.out.println(extractLowestBit(0b111));//1
		
		System.out.println(extractLowestBit(0b110));//2
		System.out.println(extractLowestBit(0b1010));//2
		
		System.out.println(extractLowestBit(0b10));//2
		System.out.println(extractLowestBit(0b100));//4
		System.out.println(extractLowestBit(0b1000));//8
		System.out.println(extractLowestBit(0b10000));//16
		
		System.out.println(extractLowestBit(0b110));//2
		System.out.println(extractLowestBit(0b1100));//4
		System.out.println(extractLowestBit(0b11000));//8
		System.out.println(extractLowestBit(0b110000));//16
	}

}
