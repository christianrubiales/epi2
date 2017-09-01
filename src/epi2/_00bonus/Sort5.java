package epi2._00bonus;

import java.util.Arrays;

/**
 * Given 25 DISTINCT numbers, return top 3 while minimizing use of sort5.
 * Page 32-33
 * Form groups of 5 and sort the 5 groups, then sort the top from the groups.
 * Minimum 6 sort5 uses.
 */
public class Sort5 {
	
	static int[] sort5(int[] array) {
		Arrays.sort(array);
		return array;
	}
	
	static int[] top3(int[] array) {
		int[][] a = new int[5][];
		int[] x = new int[5];
		
		for (int i = 0; i < 5; i++) {
			a[i] = sort5(Arrays.copyOfRange(array, (i*5), (i*5) + 5)); // sort the range
			x[i] = a[i][4]; // copy the top in the sorted range
		}
		Arrays.sort(x); // sort the top from the groups
		
		return new int[] {x[4], x[3], x[2]};
	}
	
	static void print(int[] array, int[] top) {
		System.out.print("array: [");
		for (int a : array) {
			System.out.print(a + ",");
		}
		System.out.print("], top: [");
		for (int a : top) {
			System.out.print(a + ",");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		int[] array = new int[] {3, 13, 12, 23, 1, 7, 4, 5, 6, 15, 22, 19, 10, 17, 9, 8, 11, 18, 25, 2, 16, 24, 14, 20, 21};
		print(array, top3(array)); // 25,24,23
	}

}
