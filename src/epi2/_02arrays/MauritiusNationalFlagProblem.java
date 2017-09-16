package epi2._02arrays;

import java.util.Arrays;

public class MauritiusNationalFlagProblem {
	
	static enum Color {RED, BLUE, YELLOW, GREEN};
	
	static void partition(Color[] A) {
		
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int c4 = A.length - 1;
		
		while (c3 <= c4) {
			if (A[c3] == Color.values()[0]) {
				swap(A, c3, c1);
				c1++;
				
				if (c2 < c1) {
					c2++;
				}
				
				if (c3 < c1) {
					c3++;
				}
			} else if (A[c3] == Color.values()[1]) {
				swap(A, c2, c3);
				c2++;
				c3++;
			} else if (A[c3] == Color.values()[2]) {
				c3++;
			} else {
				swap(A, c3, c4);
				c4--;
			}
		}
	}
	
	static void swap(Color[] A, int i, int j) {
		Color t = A[i];
		A[i] = A[j];
		A[j] = t;
	}
	
	static void test(Color[] A) {
		partition(A);
		System.out.println(Arrays.deepToString(A));
	}

	public static void main(String[] args) {
		test(new Color[] {Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED, Color.YELLOW});
		test(new Color[] {Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED, Color.RED});
	}

}
