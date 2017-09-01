package epi2._00bonus;

import java.util.Arrays;

/**
 * Sort alternating: a[0] <= a[1] >= a[2] <= a[3] >= a[4] <= a[5] >= ...
 * Page 33
 * Swap in pairs (a[1],a[2]), (a[3],a[4])...
 * O(nlogn) due to sorting
 */
public class SortAlternatingBySortingAndSwapping {
	
	static int[] alternating(int[] array) {
		Arrays.sort(array);
		
		for (int i = 1; i < array.length; i += 2) {
			if (i+1 < array.length) {
				// swap
				int t = array[i];
				array[i] = array[i+1];
				array[i+1] = t;
			}
		}
		
		return array;
	}
	
	static void print(String label, int[] array) {
		System.out.print(label + ": [");
		for (int a : array) {
			System.out.print(a + ",");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		int[] array = new int[] {10,9,8,7,6,5,4,3,2,1};
		print("array", array);
		print("alternating", alternating(array));
	}

}
