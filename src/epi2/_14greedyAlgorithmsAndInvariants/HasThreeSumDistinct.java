package epi2._14greedyAlgorithmsAndInvariants;

import java.util.Arrays;

// O(nlogn)
public class HasThreeSumDistinct {
	
	static boolean hasThreeSum(int[] A, int sum) {
		Arrays.sort(A);
		int i = 0;
		int j = A.length - 1;
		
		while (i < j) {
			if (A[i] + A[j] <= sum) {
				int c = j-i < 2 ? -1 : Arrays.binarySearch(A, i+1, j, sum - (A[i]+A[j]));
				if (c > -1) {
//					System.out.println(A[i] + "+" + A[j] + "+" + A[c] + "=" + sum);
					return true;
				} else {
					i++;
				}
			} else if (A[i] + A[j] > sum) {
				j--;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[] A = new int[] {0,1,2,3};
		for (int i = 0; i < 15; i++) {
			System.out.println(i + " : " + hasThreeSum(A, i));
		}
	}

}
