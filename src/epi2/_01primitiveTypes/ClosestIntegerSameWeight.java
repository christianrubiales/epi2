package epi2._01primitiveTypes;

public class ClosestIntegerSameWeight {

	// find two consecutive different bits and swap them
	// O(n)
	static long closest(long n) {
		final short NUM_BITS = 63;

		for (short i = 0; i < NUM_BITS - 1; i++) {
			if (((n >>> i) & 1) != ((n >>> i + 1) & 1)) {
				return n ^ (1L << i | 1L << (i + 1));
			}
		}

		throw new IllegalArgumentException("Bits are all 0 or all 1");
	}

	// O(1)
	public static long closestIntSameBitCount(long x) {
		if (x == 0 || x == Long.MAX_VALUE) {
			throw new IllegalArgumentException("Bits are all 0 or all 1");
		}
		long mask = (x & 1) == 0 ? lowestSetBit(x) : lowestUnsetBit(x);
		mask = mask | (mask >>> 1);
		return x ^ mask;
	}

	private static long lowestSetBit(long x) {
		return x & ~(x-1);
	}

	private static long lowestUnsetBit(long x) {
		return lowestSetBit(x+1);
	}

	public static void main(String[] args) {
		System.out.println(closest(0b1));// 2
		System.out.println(closest(0b10));// 1
		System.out.println(closest(0b11));// 5

		System.out.println(closestIntSameBitCount(0b1));// 2
		System.out.println(closestIntSameBitCount(0b10));// 1
		System.out.println(closestIntSameBitCount(0b11));// 5
	}

}
