package epi2._02arrays;

import java.util.Arrays;
import java.util.Random;

public class RandomPermutationToApply {
	
	// create the initial permutation from 0 to n-1
	// then shuffle the permutation
	static Integer[] randomPermutation(int n) {
		// create the initial permutation
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++) {
			a[i] = i;
		}
		
		// shuffle the permutation
		Random random = new Random();
		for (int i = n; i > 1; i--) {
			int r = random.nextInt(i);
			Integer t = a[i-1];
			a[i-1] = a[r];
			a[r] = t;
		}
		
		return a;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(randomPermutation(6)));
	}

}
