package epi2._13dynamicProgramming;

public class FibonacciLinearInefficientSpace {
	
	static int fib(int n) {
		if (n == 0) {
			return 0;
		}
		
		int[] f = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			f[i] = f[i-2] + f[i-1];
		}
		
		return f[n];
	}

	public static void main(String[] args) {
		for (int i = 0; i < 47; i++) {
			System.out.println(fib(i));
		}
	}

}
