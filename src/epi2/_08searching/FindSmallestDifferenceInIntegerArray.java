package epi2._08searching;

import java.util.Arrays;

public class FindSmallestDifferenceInIntegerArray {
	
	// sort then linear search
	// O(nlogn)
	static int smallestDifference(int[] A) {
		Arrays.sort(A);
		int smallest = Integer.MAX_VALUE;
		
		for (int i = 0; i < A.length - 1; i++) {
			smallest = Math.min(smallest, A[i+1] - A[i]);
		}
		
		return smallest;
	}

	public static void main(String[] args) {
		System.out.println(smallestDifference(new int[] {2,4,6,7,8,10}));//1
		System.out.println(smallestDifference(new int[] {10,9,8,6,4,2}));//1
	}

}
