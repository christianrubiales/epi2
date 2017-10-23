package epi2._01primitiveTypes;

public class PropagateRighmostSetBit {
	
	static byte propagate(byte x) {
		return x |= x-1;
	}

	public static void main(String[] args) {
		for (byte i = 0; i <= 8; i++) {
			System.out.println(propagate(i));
		}
		// 00000000 (0) -> 11111111 (-1)
		// 00000001 (1) -> 00000001 (1)
		// 00000010 (2) -> 00000011 (3)
		// 00000010 (3) -> 00000011 (3)
		// 00000100 (4) -> 00000111 (7)
		// 00000101 (5) -> 00000101 (5)
		// 00000110 (6) -> 00000111 (7)
		// 00000111 (7) -> 00000111 (7)
		// 00001000 (8) -> 00001111 (15)
	}

}
