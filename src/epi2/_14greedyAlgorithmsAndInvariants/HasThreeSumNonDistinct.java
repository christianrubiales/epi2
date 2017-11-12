package epi2._14greedyAlgorithmsAndInvariants;

import java.util.Arrays;

// O(nlogn) time
// O(1) space if no copy is made and original array is modified
// O(n) space if copy of original array is necessary
public class HasThreeSumNonDistinct {
	
	static boolean hasThreeSum(int[] A, int sum) {
		Arrays.sort(A);
		int i = 0;
		int j = A.length - 1;
		
		while (i <= j) {
			if (Arrays.binarySearch(A, sum - (A[i]+A[j])) > -1) {
//				System.out.println(A[i] + "+" + A[j] + "+" + A[Arrays.binarySearch(A, sum - (A[i]+A[j]))] + "=" + sum);
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
		int[] A = new int[] {-2,-1,0,1,2,3};
		for (int i = -7; i < 15; i++) {
			System.out.println(i + " : " + hasThreeSum(A, i));
		}
	}

}
