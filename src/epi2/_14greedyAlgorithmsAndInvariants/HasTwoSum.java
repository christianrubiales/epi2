package epi2._14greedyAlgorithmsAndInvariants;

import java.util.Arrays;

// O(n^2)
public class HasTwoSum {
	
	static boolean hasTwoSum(int[] A, int sum) {
		Arrays.sort(A);
		
		int i = 0;
		int j = A.length - 1;
		
		while (i <= j) {
			if (A[i] + A[j] == sum) {
//				System.out.println(A[i] + "+" + A[j] + "=" + sum);
				return true;
			} else if (A[i] + A[j] < sum) {
				i++;
			} else {
				j--;
			}
		}
		
		return false;
	}
	
	static boolean hasThreeSum(int[] A, int sum) {
		for (int a : A) {
			if (hasTwoSum(A, sum - a)) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[] A = new int[] {-3,-2,-1,0,1,2,3};
		for (int i = -10; i < 10; i++) {
			System.out.println(i + " : " + hasTwoSum(A, i));
		}
		System.out.println();
		
		for (int i = -10; i < 13; i++) {
			System.out.println(i + " : " + hasThreeSum(A, i));
		}
	}

}
