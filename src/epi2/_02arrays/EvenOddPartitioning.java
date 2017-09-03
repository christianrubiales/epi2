package epi2._02arrays;

import java.util.Arrays;

public class EvenOddPartitioning {
	
	// use two pointers, swapping the front entry with the back if not even
	static int[] evenOddPartition(int[] b) {
		int[] a = Arrays.copyOf(b, b.length);
		int i = 0;
		int j = a.length - 1;
		
		while (i < j) {
			// swap with back if not even
			if (a[i] % 2 != 0) {
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
			
			j--;
			
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
		print(new int[] {1,2,3,4,5,6,7,8,9}, evenOddPartition(new int[] {1,2,3,4,5,6,7,8,9}));
	}

}
