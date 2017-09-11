package epi2._02arrays;

import java.util.Arrays;

public class OddEvenPartitioning {
	
	// use two pointers, swapping the front entry with the back if not odd
	// O(n)
	static int[] oddEvenPartition(int[] b) {
		int[] a = Arrays.copyOf(b, b.length);
		int i = 0; // front pointer
		int j = a.length - 1; // back pointer
		
		while (i < j) {
			// swap with back pointer if front pointer is not odd
			if (a[i] % 2 == 0) {
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
			
			// increment front pointer if already odd
			if (a[i] % 2 != 0) {
				i++;
			}

			// decrement back pointer if already even
			if (a[j] % 2 == 0) {
				j--;
			}
		}
		
		return a;
	}
	
	static void print(int[] a, int[] sorted) {
		System.out.print("array: [");
		for (int x : a) {
			System.out.print(x + ",");
		}
		System.out.print("], sorted: [");
		for (int x : sorted) {
			System.out.print(x + ",");
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		print(new int[] {1,2}, oddEvenPartition(new int[] {1,2}));
		print(new int[] {1,2,3}, oddEvenPartition(new int[] {1,2,3}));
		print(new int[] {1,2,3,4,5,6,7,8,9}, oddEvenPartition(new int[] {1,2,3,4,5,6,7,8,9}));
		print(new int[] {1,2,3,4,5,6,7,8,9,10}, oddEvenPartition(new int[] {1,2,3,4,5,6,7,8,9,10}));
		print(new int[] {1,2,3,4,5,6,7,8,9,10,11}, oddEvenPartition(new int[] {1,2,3,4,5,6,7,8,9,10,11}));
		print(new int[] {1,3,5,7,9}, oddEvenPartition(new int[] {1,3,5,7,9}));
		print(new int[] {2,4,6,8,1,3,5,7,9}, oddEvenPartition(new int[] {2,4,6,8,1,3,5,7,9}));
		print(new int[] {2,4,6,8}, oddEvenPartition(new int[] {2,4,6,8}));
	}

}
