package epi2._01primitiveTypes;

public class AddWithoutArithmeticOperatorsRecursive {

	// O(n)
	static long add(long x, long y) {
		if (y == 0) {
			return x;
		} else {
			return add(x ^ y, (x & y) << 1);
		}
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
		System.out.println(add(Integer.MAX_VALUE, Integer.MAX_VALUE));//4294967294
	}

}
