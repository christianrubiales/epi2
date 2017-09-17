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
		
		// 2) find first i where A[i] < A[i+1] (non-descending)
		int i = A.length - 2;
		while (i > -1 && A[i] >= A[i+1]) {
			i--;
		}
		
		// 3) last permutation already reached
		if (i == -1) {
			return null;
		}
		
		// 4) find rightmost entry greater than A[i], then swap
		for (int j = A.length - 1; j > i; j--) {
			if (A[i] < A[j]) {
				swap(A, i, j);
				break;
			}
		}
		
		// 5) reverse the descending sequence
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
		System.out.println(Arrays.deepToString(nextPermutation(new Integer[] {1,0,3,2}))); // 1,2,0,3
		System.out.println(Arrays.deepToString(nextPermutation(new Integer[] {3,2,1,0}))); // null

	}

}
