package epi2._02arrays;

import java.util.Arrays;

// given an array of colors, partition array around a pivot
public class DutchNationalFlagProblem {
	
	static enum Color {RED, WHITE, BLUE};
	
	// reorder elements around a pivot
	static void partition(Color[] A, Color pivot) {
		
		// use 3 pointers
		int l = 0; // lower than pivot
		int u = 0; // unclassified
		int h = A.length - 1; // higher than pivot
		
		while (u <= h) {
			if (A[u].ordinal() < pivot.ordinal()) {
				swap(A, l, u); // swap A[u] and A[l]
				l++;
				u++;
			} else if (A[u].ordinal() > pivot.ordinal()) {
				swap(A, u, h); // swap A[u] and A[h]
				h--;
			} else {
				u++;
			}
		}
	}
	
	static void swap(Color[] A, int i, int j) {
		Color t = A[i];
		A[i] = A[j];
		A[j] = t;
	}
	
	static void test(Color[] A) {
		partition(A, Color.WHITE);
		System.out.println(Arrays.deepToString(A));
	}

	public static void main(String[] args) {
		test(new Color[] {Color.BLUE, Color.BLUE, Color.WHITE, Color.RED, Color.WHITE});
		test(new Color[] {Color.WHITE, Color.BLUE, Color.BLUE, Color.RED, Color.RED});
		test(new Color[] {Color.BLUE, Color.BLUE, Color.RED, Color.RED, Color.RED});
	}

}
