package epi2._13dynamicProgramming;

public class FibonacciQuadratic {
	
	static int fib(int n) {
		if (n < 2) {
			return n;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 47; i++) {
			System.out.println(fib(i));
		}
	}

}
