package epi2._21honorsClass;

public class GCDRecursive {
	
	static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	public static void main(String[] args) {
		for (int a = 0; a < 5; a++) {
			for (int b = 0; b < 5; b++) {
				System.out.println("a: " + a + " b: " + b + " gcd:" + gcd(a, b));
			}
		}

		// slightly slower than iterative version
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			gcd(1, i);
		}
		System.out.println(System.currentTimeMillis() - start);
	}

}
