package epi2._00bonus;

import java.util.Arrays;

/**
 * Two Sum.
 * Sort and use two pointers.
 * O(nlogn) due to sorting, O(n) afterwards with use of two pointers
 */
public class TwoSumBySorting {
	
	static void twoSum(int[] a, int k) {
		Arrays.sort(a);
		
		int i = 0;
		int j = a.length - 1;
		int sum = 0;
		
		while (i <= j) {
			sum = a[i] + a[j];
			if (sum == k) {
				System.out.println(a[i] + " + " + a[j] + " = " + k);
				return;
			} else if (sum < k) {
				i++;
			} else {
				j--;
			}
		}
		
		System.out.println("None found.");
	}

	public static void main(String[] args) {
		twoSum(new int[] {10,9,8,7,6,5,4,3,2,1}, 3);
	}

}
