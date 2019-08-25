package epi2._14greedyAlgorithmsAndInvariants;

import java.util.Arrays;

public class HasTwoSumDistinct {
	
	// O(n) time, O(1) space
	static boolean hasTwoSum(int[] numbers, int sum) {
		if (numbers == null || numbers.length < 2) {
			return false;
		}

		Arrays.sort(numbers);

		int i = 0;
		int j = numbers.length - 1;
		
		while (i < j) {
			if (numbers[i] + numbers[j] == sum) {
//				System.out.println(A[i] + "+" + A[j] + "=" + sum);
				return true;
			} else if (numbers[i] + numbers[j] < sum) {
				i++;
			} else {
				j--;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[] A = new int[] {-3,-2,-1,0,1,2,3};
		for (int i = -10; i < 10; i++) {
			System.out.println(i + " : " + hasTwoSum(A, i));
		}
	}

}
