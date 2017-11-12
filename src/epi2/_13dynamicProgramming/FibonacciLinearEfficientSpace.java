package epi2._13dynamicProgramming;

public class FibonacciLinearEfficientSpace {
	
	static int fib(int n) {
		if (n < 2) {
			return n;
		}
		
		int f1 = 0;
		int f2 = 1;
		int f = 0;
		
		for (int i = 2; i <= n; i++) {
			f = f2 + f1;
			f1 = f2;
			f2 = f;
		}
		
		return f;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 47; i++) {
			System.out.println(fib(i));
		}
	}

}
