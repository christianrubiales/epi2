package epi2._08searching;

import java.util.Arrays;

public class FindSmallestDifferenceInIntegerArray {
	
	// sort then linear search
	// O(nlogn) time, O(1) space
	static int smallestDifference(int[] numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("input should not be null or has less than two elements");
		}

		Arrays.sort(numbers);
		int smallest = Integer.MAX_VALUE;
		
		for (int i = 0; i < numbers.length - 1; i++) {
			int diff = numbers[i+1] - numbers[i];
			if (diff < smallest) {
				smallest = diff;
			}
		}
		
		return smallest;
	}

	public static void main(String[] args) {
		System.out.println(smallestDifference(new int[] {2,4,6,7,8,10}));//1
		System.out.println(smallestDifference(new int[] {10,9,8,6,4,2}));//1
	}

}
