package epi2._01primitiveTypes;

public class CountBits {
	
	// n & 1 equals either 1 or 0
	static short countBits(int n) {
		short bits = 0;
		
		while (n != 0) {
			bits += n & 1;
			n >>>= 1;
		}
		
		return bits;
	}

	public static void main(String[] args) {
		System.out.println(countBits(12));//2
		System.out.println(countBits(7));//3
	}

}
