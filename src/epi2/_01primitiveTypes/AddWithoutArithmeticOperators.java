package epi2._01primitiveTypes;

public class AddWithoutArithmeticOperators {
	
	static long add(long x, long y) {
		while (y != 0) {
			long carry = x & y;
			x = x ^ y; // sum
			y = carry << 1L;
		}
		
		return x;
	}

	public static void main(String[] args) {
		System.out.println(add(0, 0));//0
		System.out.println(add(0, 1));//1
		System.out.println(add(1, 0));//1
		System.out.println(add(1, 2));//3
		System.out.println(add(-1, 2));//1
		System.out.println(add(1, -2));//-1
		System.out.println(add(-1, -2));//-3
		System.out.println(add(2, 1));//3
		System.out.println(add(2, -1));//1
		System.out.println(add(Integer.MAX_VALUE, Integer.MAX_VALUE));
	}

}
