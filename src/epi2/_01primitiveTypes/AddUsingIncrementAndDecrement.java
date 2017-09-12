package epi2._01primitiveTypes;

public class AddUsingIncrementAndDecrement {
	
	static long add(long x, long y) {
		while (x != 0) {
			y++;
			x--;
		}
		return y;
	}

	public static void main(String[] args) {
		System.out.println(add(0, 0));//0
		System.out.println(add(0, 1));//1
		System.out.println(add(1, 0));//1
		System.out.println(add(1, 2));//3
		System.out.println(add(2, 1));//3
		System.out.println(add(Integer.MAX_VALUE, Integer.MAX_VALUE));
	}

}
