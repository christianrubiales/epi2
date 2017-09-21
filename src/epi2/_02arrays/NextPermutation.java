package epi2._02arrays;

import java.util.Arrays;

/**
 * @see https://discuss.leetcode.com/topic/30212/easiest-java-solution/2
 */
public class NextPermutation {
	
	static Integer[] nextPermutation(Integer[] A) {
		// 1) handle arrays with less than two entries
		if (A == null || A.length < 2) {
			return null;
		}
		
		// 2) find rightmost i where A[i] < A[i+1]
		int i = A.length - 2;
		while (i > -1 && A[i] >= A[i+1]) {
			i--;
		}
		
		// 3) if already the last permutation, return null
		if (i == -1) {
			return null;
		}
		
		// 4) find rightmost entry greater than A[i], then swap
		for (int j = A.length - 1; j > i; j--) {
			if (A[j] > A[i]) {
				swap(A, i, j);
				break;
			}
		}
		
		// 5) reverse from A[i+1] to end
		reverse(A, i+1, A.length - 1);
		
		return A;
	}
	
	static Integer[] previousPermutation(Integer[] A) {
		// 1) handle arrays with less than two items
		if (A == null || A.length < 2) {
			return null;
		}
		
		// 2) find first i from right where A[i] <= A[i+1]
		int i = A.length - 2;
		while (i > -1 && A[i] <= A[i+1]) {
			i--;
		}
		
		// 3) if last permutation already reached, return null
		if (i == -1) {
			return null;
		}
		
		// 4) find rightmost entry less than A[i-1], then swap
		for (int j = A.length - 1; j > i; j--) {
			if (A[j] < A[i]) {
				swap(A, i, j);
				break;
			}
		}
		
		// 5) reverse the descending sequence, from A[i+1] to end
		reverse(A, i+1, A.length - 1);
		
		return A;
	}
	
	static void swap(Integer[] A, int i, int j) {
		Integer t = A[i];
		A[i] = A[j];
		A[j] = t;
	}
	
	static void reverse(Integer[] A, int i, int j) {
		while (i < j) {
			swap(A, i, j);
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		Integer[] A = new Integer[] {1,2,3};
		while (A != null) {
			System.out.println(Arrays.deepToString(A));
			A = nextPermutation(A);
		}

		System.out.println(Arrays.deepToString(nextPermutation(new Integer[] {1,2,1}))); // 2,1,1
		System.out.println(Arrays.deepToString(nextPermutation(new Integer[] {1,0,3,2}))); // 1,2,0,3
		System.out.println(Arrays.deepToString(nextPermutation(new Integer[] {3,2,1,0}))); // null
		
		System.out.println(Arrays.deepToString(previousPermutation(new Integer[] {1,2,0,3}))); // 1,0,3,2
		System.out.println(Arrays.deepToString(previousPermutation(new Integer[] {0,1,2,3}))); // null
		System.out.println(Arrays.deepToString(previousPermutation(new Integer[] {0,1,3,2}))); // 0,1,2,3

	}

}
