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
	
	// https://en.wikipedia.org/wiki/Exponentiation_by_squaring#Basic_method
	static double powIterative(double x, long n) {
		if (n < 0) {
			n = -n;
			x = 1/x;
		}
		if (n == 0) {
			return 1;
		}
		
		double y = 1;
		while (n > 1) {
			if (n % 2 == 0) {
				x = x * x;
				n = n / 2;
			} else {
				y = x * y;
				x = x * x;
				n = (n - 1) / 2;
			}
		}
		
		return x * y;
	}
	
	// https://www.geeksforgeeks.org/write-an-iterative-olog-y-function-for-powx-y/
	// also EPI
	static double powiterativeGeeksForGeeks(double x, long n) {
		double result = 1.0;
		
		if (n < 0) {
			n = -n;
			x = 1/x;
		}
		
		while (n != 0) {
			if ((n & 1) == 1) { // odd
				result *= x;
			}
			n >>= 1; // n = n/2
			x *= x; // x^2
		}
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(pow(2,-3));//0.125
		System.out.println(pow(2,-2));//0.25
		System.out.println(pow(2,-1));//0.5
		System.out.println(pow(2,0));//1
		System.out.println(pow(2,1));//2
		System.out.println(pow(2,2));//4
		System.out.println(pow(2,3));//8

		System.out.println(powIterative(2,-3));//0.125
		System.out.println(powIterative(2,-2));//0.25
		System.out.println(powIterative(2,-1));//0.5
		System.out.println(powIterative(2,0));//1
		System.out.println(powIterative(2,1));//2
		System.out.println(powIterative(2,2));//4
		System.out.println(powIterative(2,3));//8
		System.out.println(powIterative(2,4));//16
		System.out.println(powIterative(2,5));//32
		System.out.println(powIterative(2,6));//64
		System.out.println(powIterative(2,7));//128
		System.out.println(powIterative(2,8));//256

		System.out.println(powiterativeGeeksForGeeks(2,-3));//0.125
		System.out.println(powiterativeGeeksForGeeks(2,-2));//0.25
		System.out.println(powiterativeGeeksForGeeks(2,-1));//0.5
		System.out.println(powiterativeGeeksForGeeks(2,0));//1
		System.out.println(powiterativeGeeksForGeeks(2,1));//2
		System.out.println(powiterativeGeeksForGeeks(2,2));//4
		System.out.println(powiterativeGeeksForGeeks(2,3));//8
		System.out.println(powiterativeGeeksForGeeks(2,4));//16
		System.out.println(powiterativeGeeksForGeeks(2,5));//32
		System.out.println(powiterativeGeeksForGeeks(2,6));//64
		System.out.println(powiterativeGeeksForGeeks(2,7));//128
		System.out.println(powiterativeGeeksForGeeks(2,8));//256
	}

}
