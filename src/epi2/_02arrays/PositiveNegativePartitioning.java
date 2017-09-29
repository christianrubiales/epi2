package epi2._02arrays;

import java.util.Arrays;


/**
 * @see https://www.careercup.com/question?id=5201559730257920
 */
public class PositiveNegativePartitioning {
	
	// Most pivoting do not work.
	// @see http://algs4.cs.princeton.edu/lectures/23DemoPartitioning.pdf
	// Partitioning a doubly-linked list however, should be O(n) time, O(1) space
	
	/**
	 * O(n) time, O(1) space
	 * @see https://stackoverflow.com/a/18535329/5459839
	 */
	static Integer[] partition(Integer[] A) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		// fin minimum and maximum values
		for (int i = 0; i < A.length; i++) {
			min = Math.min(min, A[i]);
			max = Math.max(max, A[i]);
		}

		// Change all values to Positive
		for (int i = 0; i < A.length; i++) {
			A[i] -= min;
		}

		int newMax = max - min + 1;

		// Save original positive values into new positions
		int currNegativeIndex = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % newMax > (-min)) {
				A[currNegativeIndex++] += (A[i] % newMax) * newMax;
			}
		}

		// Save original negative values into new positions
		int currPositiveIndex = currNegativeIndex;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % newMax < (-min)) {
				A[currPositiveIndex++] += (A[i] % newMax) * newMax;
			}
		}

		// Recover the original values
		for (int i = 0; i < A.length; i++) {
			A[i] = A[i] / newMax + min;
		}

		return A;
	}
	
	static void swap(Integer[] A, int i, int j) {
		Integer t = A[i];
		A[i] = A[j];
		A[j] = t;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(partition(new Integer[] {1,2,3,-1,-2,-3})));
		System.out.println(Arrays.deepToString(partition(new Integer[] {1,-1,2,-2,3,-3})));
		System.out.println(Arrays.deepToString(partition(new Integer[] {-1,-2,-3,-1,-2,-3})));
		System.out.println(Arrays.deepToString(partition(new Integer[] {1,2,3,1,2,3})));
		System.out.println(Arrays.deepToString(partition(new Integer[] {4,-8,6,-3,5,-9,3})));

	}

}
