package epi2._02arrays;

import java.util.HashSet;
import java.util.Set;

public class HeapsPermutationRecursive {
	static Set<String> set = new HashSet<>();

	static void generate(char[] A) {
		generate(A.length, A);
	}
	
	static void generate(int n, char[] A) {
		if (n == 0) {
			System.out.println(A);
		} else {
			for (int i = 0; i < n; i++) {
				generate(n - 1, A);
				if (n % 2 == 0) {
					swap(A, i, n-1);
				} else {
					swap(A, 0, n-1);
				}
			}
		}
	}
	
	static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
//		generate("ABC".toCharArray());
//		generate("1234".toCharArray());
		generate("ABCDE".toCharArray());
//		generate("312".toCharArray());
		System.out.println(set.size());
	}
}
