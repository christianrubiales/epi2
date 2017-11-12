package epi2._14greedyAlgorithmsAndInvariants;

import java.util.Arrays;

// Valid only for non-negative inputs
// O(nlogn)
// FIXME
public class HasThreeSumDistinct {
	
	static boolean hasThreeSum(int[] A, int sum) {
		Arrays.sort(A);
		int i = 0;
		int j = A.length - 1;
		
		while (i < j) {
			int c = Arrays.binarySearch(A, i+1, j, sum - (A[i]+A[j]));
			if (c > -1) {
//				System.out.println(A[i] + "+" + A[j] + "+" + A[c] + "=" + sum);
				return true;
			}
			if (A[i] + A[j] <= sum) {
				i++;
			} else if (A[i] + A[j] > sum) {
				j--;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[] A = new int[] {0,1,2,3};
		for (int i = -1; i < 10; i++) {
			System.out.println(i + " : " + hasThreeSum(A, i));
		}
	}

}
