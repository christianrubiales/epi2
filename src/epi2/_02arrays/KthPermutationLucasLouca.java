package epi2._02arrays;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationLucasLouca {

	private static int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}

		return result;
	}

	public static String solve(char[] s, int k) {
		StringBuffer sb = new StringBuffer();

		List<Character> symbols = new ArrayList<Character>();
		for (int i = 0; i < s.length; i++) {
			symbols.add(s[i]);
		}

		int n = symbols.size();
		int fact = factorial(n - 1);
		int i;
		while (n > 0) {
			i = k / fact;
			sb.append(symbols.get(i));
			symbols.remove(i);
			k = k % fact; // Rest
			fact /= Math.max(1, (n - 1)); // (n-1)!, (n-2)!, (n-3)!, ... 
			n--;
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		// add chars a - j
		int n = 4;
		char[] s = new char[n];
		for (int c = 97; c < 97 + n; c++) {
			s[c - 97] = (char) c;
		}

		for (int i = 0; i < 24; i++) {
			System.out.println(solve(s, i));
		}
	}

}
