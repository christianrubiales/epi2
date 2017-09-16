package epi2._01primitiveTypes;

public class ExtractLowestUnsetBit {
	
	static int lowestUnsetBit(int x) {
		return lowestSetBit(x+1);
	}

	static int lowestSetBit(int x) {
		return x & ~(x-1);
	}

	public static void main(String[] args) {
		System.out.println(lowestUnsetBit(0b1));//2 ->10
		System.out.println(lowestUnsetBit(0b11));//4 -> 100
		System.out.println(lowestUnsetBit(0b111));//8 -> 1000
		
		System.out.println(lowestUnsetBit(0b110));//1
		System.out.println(lowestUnsetBit(0b1010));//1
		
		System.out.println(lowestUnsetBit(0b10));//1
		System.out.println(lowestUnsetBit(0b100));//1
		System.out.println(lowestUnsetBit(0b1000));//1
		System.out.println(lowestUnsetBit(0b10000));//1
		
		System.out.println(lowestUnsetBit(0b110));//1
		System.out.println(lowestUnsetBit(0b1100));//1
		System.out.println(lowestUnsetBit(0b11000));//1
		System.out.println(lowestUnsetBit(0b110000));//1
	}

}
