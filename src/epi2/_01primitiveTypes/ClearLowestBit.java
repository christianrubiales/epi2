package epi2._01primitiveTypes;

public class ClearLowestBit {
	
	static int clearLowestBit(int x) {
		return x & (x-1);
	}

	public static void main(String[] args) {
		System.out.println(clearLowestBit(1));//0
		System.out.println(clearLowestBit(3));//2
		System.out.println(clearLowestBit(7));//6
		
		System.out.println(clearLowestBit(6));//4
		System.out.println(clearLowestBit(10));//8
		
		System.out.println(clearLowestBit(2));//0
		System.out.println(clearLowestBit(4));//0
		System.out.println(clearLowestBit(8));//0
		System.out.println(clearLowestBit(16));//0
	}

}
