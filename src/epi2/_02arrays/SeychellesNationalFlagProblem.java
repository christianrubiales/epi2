package epi2._02arrays;

import java.util.Arrays;

public class SeychellesNationalFlagProblem {
	
	static enum Color {BLUE, YELLOW, RED, WHITE, GREEN};
	
	static void partition(Color[] A) {
		
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int c4 = 0;
		int c5 = A.length - 1;
		
		while (c4 <= c5) {
			if (A[c4] == Color.values()[0]) {
				swap(A, c4, c1);
				c1++;
				
				if (c2 < c1) {
					c2++;
				}
				
				if (c3 < c1) {
					c3++;
				}
				
				if (c4 < c1) {
					c4++;
				}
			} else if (A[c4] == Color.values()[1]) {
				swap(A, c2, c4);
				c2++;
				
				if (c3 < c2) {
					c3++;
				}
				
				if (c4 < c2) {
					c4++;
				}
			} else if (A[c4] == Color.values()[2]) {
				swap(A, c3, c4);
				c3++;
				c4++;
			} else if (A[c4] == Color.values()[3]) {
				c4++;
			} else {
				swap(A, c4, c5);
				c5--;
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
		test(new Color[] {Color.BLUE, Color.WHITE, Color.GREEN, Color.YELLOW, Color.RED, Color.YELLOW});
		test(new Color[] {Color.YELLOW, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED, Color.RED});
	}

}
