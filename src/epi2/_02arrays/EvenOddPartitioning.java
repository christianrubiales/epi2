package epi2._02arrays;

import java.util.Arrays;

public class EvenOddPartitioning {
	
	// use two pointers, swapping the front entry with the back if not even
	// O(n)
	static int[] evenOddPartition(int[] b) {
		int[] a = Arrays.copyOf(b, b.length);
		int i = 0; // front pointer
		int j = a.length - 1; // back pointer
		
		while (i < j) {
			// swap with back pointer if front pointer is not even
			if (a[i] % 2 != 0) {
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
			
			// always decrement back pointer
			j--;
			
			// increment front pointer if even
			if (a[i] % 2 == 0) {
				i++;
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
		print(new int[] {1,2}, evenOddPartition(new int[] {1,2}));
		print(new int[] {1,2,3,4,5,6,7,8,9}, evenOddPartition(new int[] {1,2,3,4,5,6,7,8,9}));
		print(new int[] {1,2,3,4,5,6,7,8,9,10}, evenOddPartition(new int[] {1,2,3,4,5,6,7,8,9,10}));
		print(new int[] {1,2,3,4,5,6,7,8,9,10,11}, evenOddPartition(new int[] {1,2,3,4,5,6,7,8,9,10,11}));
		print(new int[] {1,3,5,7,9}, evenOddPartition(new int[] {1,3,5,7,9}));
		print(new int[] {2,4,6,8,1,3,5,7,9}, evenOddPartition(new int[] {2,4,6,8,1,3,5,7,9}));
		print(new int[] {2,4,6,8}, evenOddPartition(new int[] {2,4,6,8}));
	}

}
