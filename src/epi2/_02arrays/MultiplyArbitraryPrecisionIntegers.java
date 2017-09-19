package epi2._02arrays;

import java.util.Arrays;

// big integer multiplication
public class MultiplyArbitraryPrecisionIntegers {
	
	static Integer[] multiply(Integer[] x, Integer[] y) {

		// handle sign
		int sign = (x[0] < 0) ^ y[0] < 0 ? -1 : 1;
		x[0] = Math.abs(x[0]);
		y[0] = Math.abs(y[0]);
		
		// long multiplication
		Integer[] result = new Integer[x.length + y.length];
		Arrays.fill(result, 0);
		for (int i = x.length - 1; i >= 0; i--) {
			for (int j = y.length - 1; j >= 0; j--) {
				result[i+j+1] = result[i+j+1] + x[i] * y[j];
				result[i+j]   = result[i+j]   + result[i+j+1] / 10;
				result[i+j+1] = result[i+j+1] % 10;
			}
		}
		
		// remove leading zeroes
		int i = 0;
		while (i < result.length && result[i] == 0) {
			i++;
		}
		result = Arrays.copyOfRange(result, i, result.length);
		if (result.length == 0) {
			return new Integer[] {0};
		}
		
		// return with correct sign
		result[0] = result[0] * sign;
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(multiply(new Integer[] {1,2,3}, new Integer[] {1,0}))); // 1,2,3,0
		System.out.println(Arrays.deepToString(multiply(new Integer[] {0}, new Integer[] {1}))); // 0
		System.out.println(Arrays.deepToString(multiply(new Integer[] {1}, new Integer[] {1}))); // 1
		System.out.println(Arrays.deepToString(multiply(new Integer[] {-1}, new Integer[] {1}))); // -1
		System.out.println(Arrays.deepToString(multiply(new Integer[] {1,1,1,1,1,1,1}, new Integer[] {1,1,1,1,1,1,1}))); // 1234567654321
	}

}
