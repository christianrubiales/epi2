package epi2._01primitiveTypes;

public class AddWithoutArithmeticOperatorsRecursive {
	
	static long add(long x, long y) {
		long sum = 0;
		long carry = 0;
		
		if (y == 0) {
			return x;
		}
		sum = x ^ y;
		carry = (x & y) << 1L;
		
		return add(sum, carry);
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
