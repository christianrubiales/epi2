package epi2._02arrays;

import java.util.Arrays;

public class RemoveElementFromArray {
	
	static int[] removeElement(int[] b, int k) {
		int[] a = Arrays.copyOf(b, b.length);
		int index = 0;
		int matches = 0;

		// if current is different from k,
		// overwrite position having k, which is a[index], with a[i]
		// else, increment matches
		for (int i = 0; i < a.length; i++) {
			if (a[i] != k) {
				a[index++] = a[i];
			} else {
				matches++;
			}
		}
		
		// fill trailing with zeroes
		for (int i = 0; i < matches; i++) {
			a[a.length - matches + i] = 0;
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
		print(new int[] {3,1,2,3,4,3,3,5,3,6,3}, removeElement(new int[] {3,1,2,3,4,3,3,5,3,6,3}, 3));//1,2,4,5,6,0,0,0,0,0,0
	}

}
