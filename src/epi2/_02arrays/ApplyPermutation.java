package epi2._02arrays;

import java.util.Arrays;

public class ApplyPermutation {
	
	public static Object[] applyPermutation(Object[] A, Integer[] perm) {

	    // Fix elements one by one
	    for (int i = 0; i < A.length; i++)
	    {
	        // While perm[i] and arr[i] are not fixed
	        while (perm[i] != i)
	        {
	            // Copy old values before overwriting
	            Object oldTargetObject  = A[perm[i]];
	            int oldTargetIndex  = perm[perm[i]];
	 
	            // Place A[i] at its target position
	            // Copy corrected index for new position
	            A[perm[i]] = A[i];
	            perm[perm[i]] = perm[i];
	 
	            // Copy old targets
	            A[i] = oldTargetObject;
	            perm[i] = oldTargetIndex;
	        }
	    }
	    
		return A;
	}

	public static Object[] applyPermutationEPI(Object[] A, int[] perm) {
		for (int i = 0; i < A.length; ++i) {
			// Traverse the cycle to see if i is the minimum element.
			boolean isMin = true;
			int j = perm[i];
			while (j != i) {
				if (j < i) {
					isMin = false;
					break;
				}
				j = perm[j];
			}

			if (isMin) {
				cyclicPermutation(i, A, perm);
			}
		}
		return A;
	}

	private static void cyclicPermutation(int start, Object[] A, int[] perm) {
		int i = start;
		Object temp = A[start];
		do {
			int nextI = perm[i];
			Object nextTemp = A[nextI];
			A[nextI] = temp;
			i = nextI;
			temp = nextTemp;
		} while (i != start);
	}

	// not space efficient
	// O(n) time, O(n) space
	static Object[] applyPermutationWithAdditionalSpace(Object[] array, int[] permutation) {
		Object[] result = new Object[array.length];

		for (int i = 0; i < array.length; i++) {
			result[permutation[i]] = array[i];
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(applyPermutation(new Object[] {"a","b"}, new Integer[] {1,0})));// b,a
		System.out.println(Arrays.deepToString(applyPermutation(new Object[] {"a","b","c"}, new Integer[] {2,0,1})));// b,c,a
		
		System.out.println(Arrays.deepToString(applyPermutation(new Object[] { "a", "b", "c", "d", }, new Integer[] { 2, 0, 1, 3 })));// b,c,a,d
		System.out.println(Arrays.deepToString(applyPermutation(new Object[] { "a", "b", "c", "d", }, new Integer[] { 2, 0, 3, 1 })));// b,d,a,c
		System.out
				.println(Arrays.deepToString(applyPermutation(new Object[] { "a", "b", "c" }, new Integer[] { 0, 1, 2 })));// a,b,c
		System.out
				.println(Arrays.deepToString(applyPermutation(new Object[] { "a", "b", "c" }, new Integer[] { 0, 2, 1 })));// a,c,b
		System.out
				.println(Arrays.deepToString(applyPermutation(new Object[] { "a", "b", "c" }, new Integer[] { 2, 0, 1 })));// b,c,a
		System.out
				.println(Arrays.deepToString(applyPermutation(new Object[] { "a", "b", "c" }, new Integer[] { 2, 1, 0 })));// c,b,a
		System.out
				.println(Arrays.deepToString(applyPermutation(new Object[] { "a", "b", "c" }, new Integer[] { 1, 2, 0 })));// c,a,b
		System.out
				.println(Arrays.deepToString(applyPermutation(new Object[] { "a", "b", "c" }, new Integer[] { 1, 0, 2 })));// b,a,c

		System.out.println(Arrays.deepToString(applyPermutationEPI(new Object[] { "a", "b", "c", "d", }, new int[] { 2, 0, 1, 3 })));// b,c,a,d
		System.out.println(Arrays.deepToString(applyPermutationEPI(new Object[] { "a", "b", "c", "d", }, new int[] { 2, 0, 3, 1 })));// b,d,a,c
		System.out
				.println(Arrays.deepToString(applyPermutationEPI(new Object[] { "a", "b", "c" }, new int[] { 0, 1, 2 })));// a,b,c
		System.out
				.println(Arrays.deepToString(applyPermutationEPI(new Object[] { "a", "b", "c" }, new int[] { 0, 2, 1 })));// a,c,b
		System.out
				.println(Arrays.deepToString(applyPermutationEPI(new Object[] { "a", "b", "c" }, new int[] { 2, 0, 1 })));// b,c,a
		System.out
				.println(Arrays.deepToString(applyPermutationEPI(new Object[] { "a", "b", "c" }, new int[] { 2, 1, 0 })));// c,b,a
		System.out
				.println(Arrays.deepToString(applyPermutationEPI(new Object[] { "a", "b", "c" }, new int[] { 1, 2, 0 })));// c,a,b
		System.out
				.println(Arrays.deepToString(applyPermutationEPI(new Object[] { "a", "b", "c" }, new int[] { 1, 0, 2 })));// b,a,c

		System.out.println(Arrays.deepToString(applyPermutationWithAdditionalSpace(new Object[] { "a", "b", "c", "d", }, new int[] { 2, 0, 1, 3 })));// b,c,a,d
		System.out.println(Arrays.deepToString(applyPermutationWithAdditionalSpace(new Object[] { "a", "b", "c", "d", }, new int[] { 2, 0, 3, 1 })));// b,d,a,c
		System.out.println(Arrays.deepToString(
				applyPermutationWithAdditionalSpace(new Object[] { "a", "b", "c" }, new int[] { 0, 1, 2 })));// a,b,c
		System.out.println(Arrays.deepToString(
				applyPermutationWithAdditionalSpace(new Object[] { "a", "b", "c" }, new int[] { 0, 2, 1 })));// a,c,b
		System.out.println(Arrays.deepToString(
				applyPermutationWithAdditionalSpace(new Object[] { "a", "b", "c" }, new int[] { 2, 0, 1 })));// b,c,a
		System.out.println(Arrays.deepToString(
				applyPermutationWithAdditionalSpace(new Object[] { "a", "b", "c" }, new int[] { 2, 1, 0 })));// c,b,a
		System.out.println(Arrays.deepToString(
				applyPermutationWithAdditionalSpace(new Object[] { "a", "b", "c" }, new int[] { 1, 2, 0 })));// c,a,b
		System.out.println(Arrays.deepToString(
				applyPermutationWithAdditionalSpace(new Object[] { "a", "b", "c" }, new int[] { 1, 0, 2 })));// b,a,c
	}

}
