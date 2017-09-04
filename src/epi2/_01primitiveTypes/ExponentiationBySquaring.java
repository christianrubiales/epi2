package epi2._01primitiveTypes;

public class ExponentiationBySquaring {
	
	static double pow(double x, long n) {
		if (n < 0) {
			return pow(1/x, -n);
		} else if (n == 0) {
			return 1;
		} else if (n == 1) {
			return x;
		} else if (n == 2) {
			return x * x;
		} else if (n % 2 == 0) {
			return pow(x*x, n/2);
		} else {
			return x * pow(x*x, (n-1)/2);
		}
	}
	
	static double powIterative(double x, long n) {
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(pow(2,-3));//0.125
		System.out.println(pow(2,-2));//0.25
		System.out.println(pow(2,-1));//0.5
		System.out.println(pow(2,0));//1
		System.out.println(pow(2,1));//2
		System.out.println(pow(2,2));//4
		System.out.println(pow(2,3));//8
	}

}
