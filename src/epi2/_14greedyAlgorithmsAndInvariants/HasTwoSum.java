package epi2._14greedyAlgorithmsAndInvariants;

import java.util.Arrays;

public class HasTwoSum {
	
	static boolean hasTwoSum(int[] A, int sum) {
		Arrays.sort(A);
		
		int i = 0;
		int j = A.length - 1;
		
		while (i < j) {
			if (A[i] + A[j] == sum) {
				return true;
			} else if (A[i] + A[j] < sum) {
				i++;
			} else {
				j--;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[] A = new int[] {1,2,3,4,5,6,7,8,9};
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " : " + hasTwoSum(A, i));
		}
	}

}
