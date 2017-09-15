package epi2._01primitiveTypes;

public class ShiftingTest {

	public static void main(String[] args) {
		System.out.println(1 >>> 1); // 0
		System.out.println(1 >> 1); // 0
		System.out.println(1 << 1); // 10b = 2
		System.out.println(-1 >>> 1); // 111...111 -> 011...111
		System.out.println(-1 >> 1); // 111...111 -> 111...111 (still -1)
		System.out.println(-1 << 1); // 111...111 -> 111...110 (-2)
		System.out.println(Integer.MIN_VALUE << 1);// 1000... -> 0
		System.out.println(Integer.MAX_VALUE << 1);// 0111... -> 111...110 (-2)

	}

}
