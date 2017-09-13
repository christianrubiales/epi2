package epi2._01primitiveTypes;

public class ReverseBits {
	
	// only for non-negative numbers
	// swap the leftmost and the rightmost bits, meeting at the center
	static byte reverseBits(byte n) {
		byte i = 0;
		byte j = 6;
		
		while (i < j) {
			if (((n >>> i) & 1) != ((n >>> j) & 1)) {
				n ^= (1 << i | 1 << j);
			}
			i++;
			j--;
		}
		
		return n;
	}

	public static void main(String[] args) {
		System.out.println(reverseBits((byte) 1));//64 = 1_000_000
		System.out.println(reverseBits((byte) 2));//32 = 0_100_000
		System.out.println(reverseBits((byte) 4));//16 = 0_010_000
		System.out.println(reverseBits((byte) 0));// 0
		System.out.println(reverseBits((byte) 127));// 1111111

	}

}
