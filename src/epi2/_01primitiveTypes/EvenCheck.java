package epi2._01primitiveTypes;

// No noticeable difference in times, using mod is more obvious
public class EvenCheck {
	
	static boolean isEvenUsingMod(int n) {
		return n % 2 == 0;
	}
	
	static boolean isEvenUsingAnd(int n) {
		return (n & 1) == 0;
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
			isEvenUsingMod(i);
		}
		System.out.println(System.nanoTime() - start + "ns");
		
//		long start = System.nanoTime();
//		for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
//			isEvenUsingAnd(i);
//		}
//		System.out.println(System.nanoTime() - start + "ns");
	}

}
