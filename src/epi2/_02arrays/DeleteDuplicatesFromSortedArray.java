package epi2._02arrays;

import java.util.Arrays;

public class DeleteDuplicatesFromSortedArray {
	
	static int[] removeDuplicates(int[] b) {
		int[] a = Arrays.copyOf(b, b.length);
		int index = 1;
		int dups = 0;
		
		// if index-1 is different from current, copy the current to the index, then increment index
		// else increment dups
		for (int i = 1; i < a.length; i++) {
			if (a[index - 1] != a[i]) {
				a[index++] = a[i];
			} else {
				dups++;
			}
		}
		
		// set tailing values to zero
		for (int i = 0; i < dups; i++) {
			a[a.length - dups + i] = 0;
		}
		
		return a;
	}

	
	static void print(int[] a, int[] processed) {
		System.out.print("array: [");
		for (int x : a) {
			System.out.print(x + ",");
		}
		System.out.print("], processed: [");
		for (int x : processed) {
			System.out.print(x + ",");
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		print(new int[] {1,2,2,3,4,5,5,5,6}, removeDuplicates(new int[] {1,2,2,3,4,5,5,5,6}));//1,2,3,4,5,6,0,0,0
	}

}
