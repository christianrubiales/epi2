package epi2._02arrays;

import java.util.Arrays;

public class MultiplyArbitraryPrecisionIntegers {
	
	static Integer[] multiply(Integer[] n1, Integer[] n2) {
		// handle sign
		int sign = (n1[0] < 0) ^ n2[0] < 0 ? -1 : 1;
		n1[0] = Math.abs(n1[0]);
		n2[0] = Math.abs(n2[0]);
		
		// long multiplication
		Integer[] result = new Integer[n1.length + n2.length];
		Arrays.fill(result, 0);
		for (int i = n1.length - 1; i >= 0; i--) {
			for (int j = n2.length - 1; j >= 0; j--) {
				result[i+j+1] = result[i+j+1] + n1[i] * n2[j];
				result[i+j] = result[i+j] + result[i+j+1] / 10;
				result[i+j+1] = result[i+j+1] % 10;
			}
		}
		
		// remove leading zeroes
		int index = 0;
		while (index < result.length && result[index] == 0) {
			index++;
		}
		result = Arrays.copyOfRange(result, index, result.length);
		if (result.length == 0) {
			return new Integer[] {0};
		}
		
		// return with correct sign
		result[0] = result[0] * sign;
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(multiply(new Integer[] {0}, new Integer[] {1}))); // 0
		System.out.println(Arrays.deepToString(multiply(new Integer[] {1}, new Integer[] {1}))); // 1
		System.out.println(Arrays.deepToString(multiply(new Integer[] {-1}, new Integer[] {1}))); // -1
		System.out.println(Arrays.deepToString(multiply(new Integer[] {1,1,1,1,1,1,1}, new Integer[] {1,1,1,1,1,1,1}))); // 1234567654321
	}

}
