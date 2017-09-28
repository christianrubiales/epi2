package epi2._02arrays;

import java.util.Arrays;


/**
 * @see https://www.careercup.com/question?id=5201559730257920
 */
public class NegativePositivePartitioning {
	
	// Most pivoting do not work
	// @see http://algs4.cs.princeton.edu/lectures/23DemoPartitioning.pdf
	// Partitioning a doubly-linked list however, should be O(n) time, O(1) space
	
	/**
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

		// Save original negative values into new positions
		int currNegativeIndex = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % newMax < (-min)) {
				A[currNegativeIndex++] += (A[i] % newMax) * newMax;
			}
		}

		// Save original positive values into new positions
		int currPositiveIndex = currNegativeIndex;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % newMax > (-min)) {
				A[currPositiveIndex++] += (A[i] % newMax) * newMax;
			}
		}

		// Recover the original values
		for (int i = 0; i < A.length; i++) {
			A[i] = A[i] / newMax + min;
		}

		return A;
	}
	
	// @see
	// has error in some inputs
	static Integer[] partition2(Integer[] A) {
		int i = -1;
		int pivot = 0;

//		for (int j = 0; j < A.length; j++) {
//			 if (A[j] < 0) {
//				 if (pivot == 0) {
//					pivot = A[j];
//				} else {
//					pivot = Math.max(pivot, A[j]);
//				}
//			}
//		}
		
		for (int j = 0; j < A.length; j++) {
			if (A[j] < pivot) {
				i++;
				if (i != j) {
					swap(A, i, j);
				}
			}
		}
		
		int pos = -1;
		int neg = 0;
		
		while (pos < A.length && neg < pos && A[neg] < 0) {
			swap(A, pos, neg);
			pos++;
			neg += 2;
		}
		
		return A;
	}
	
	// @see https://stackoverflow.com/a/33219647/2256169
	// DOES NOT WORK
	static Integer[] sortNumbers(Integer[] A) {
        int a = 0;
        int b = A.length - 1;
        for (int i = 0; i < A.length && i <= b; i++) {
            int cur = A[i];
            if (cur < 0) {
                swap(A, i, a);
                a++;
            } else if (cur > 0) {
                swap(A, i, b);
                b--;
                i--;
            }
        }
        return A;
    }
	
	static void swap(Integer[] A, int i, int j) {
		Integer t = A[i];
		A[i] = A[j];
		A[j] = t;
	}

	public static void main(String[] args) {
//		System.out.println(Arrays.deepToString(partition(new Integer[] {1,2,3,-1,-2,-3})));
//		System.out.println(Arrays.deepToString(partition(new Integer[] {1,-1,2,-2,3,-3})));
//		System.out.println(Arrays.deepToString(partition(new Integer[] {-1,-2,-3,-1,-2,-3})));
//		System.out.println(Arrays.deepToString(partition(new Integer[] {1,2,3,1,2,3})));
//		System.out.println(Arrays.deepToString(partition(new Integer[] {4,-8,6,-3,5,-9,3})));
		
//		System.out.println(Arrays.deepToString(partition2(new Integer[] {1,2,3,-1,-2,-3})));
//		System.out.println(Arrays.deepToString(partition2(new Integer[] {1,-1,2,-2,3,-3})));
//		System.out.println(Arrays.deepToString(partition2(new Integer[] {-1,-2,-3,-1,-2,-3})));
//		System.out.println(Arrays.deepToString(partition2(new Integer[] {1,2,3,1,2,3})));
//		System.out.println(Arrays.deepToString(partition2(new Integer[] {4,-8,6,-3,5,-9,3}))); // ERROR

//		System.out.println(Arrays.deepToString(sortNumbers(new Integer[] {1,2,3,-1,-2,-3})));
//		System.out.println(Arrays.deepToString(sortNumbers(new Integer[] {1,-1,2,-2,3,-3})));
//		System.out.println(Arrays.deepToString(sortNumbers(new Integer[] {-1,-2,-3,-1,-2,-3})));
//		System.out.println(Arrays.deepToString(sortNumbers(new Integer[] {1,2,3,1,2,3})));
//		System.out.println(Arrays.deepToString(sortNumbers(new Integer[] {4,-8,6,-3,5,-9,3})));

	}

}
