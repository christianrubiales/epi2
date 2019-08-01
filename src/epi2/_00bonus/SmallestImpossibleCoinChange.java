package epi2._00bonus;

import java.util.Arrays;

/**
 * Find smallest value not possible to form with the given a list of coins.
 * Pages 30-32
 * Maximum possible for an empty list is 0, so the minimum impossible is 0 + 1, which is the next number.
 * Maximum possible for list containing a single number is that number, so the minimum impossible is the next number.
 * Sort the list; if we come across a gap, it means we have found an impossible value.
 */
public class SmallestImpossibleCoinChange {
	
	static int getSmallest(int[] array) {
		int maxPossible = 0;
		
		if (array != null && array.length > 0) {
			Arrays.sort(array);
			
			for (int a : array) {
				if (maxPossible + 1 < a) {
					break;
				}
				maxPossible += a;
			}
		}
		
		return maxPossible + 1; // minimum impossible
	}
	
	static void print(int[] array, int max) {
		System.out.print("array: [");
		if (array != null) {
			for (int a : array) {
				System.out.print(a + ",");
			}
		}
		System.out.println("], min impossible: " + max);
	}

	public static void main(String[] args) {
		// 1,1,1,1,1,5,10,25 -> 21
		print(new int[]{1,1,1,1,1,5,10,25}, getSmallest(new int[]{1,1,1,1,1,5,10,25}));
		
		// 12,2,1,15,2,4 -> 10
		print(new int[]{12,2,1,15,2,4}, getSmallest(new int[]{12,2,1,15,2,4}));
		
		// 1,2 -> 4
		print(new int[]{1,2}, getSmallest(new int[]{1,2}));
		
		// 1,3 -> 2
		print(new int[]{1,3}, getSmallest(new int[]{1,3}));
		
		// 1 -> 2
		print(new int[]{1}, getSmallest(new int[]{1}));
		
		// [] -> 1
		print(new int[]{}, getSmallest(new int[]{}));
		
		// null -> 1
		print(null, getSmallest(new int[]{}));
	}

}
