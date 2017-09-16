package epi2._02arrays;

import java.util.Arrays;

public class DutchNationalFlagProblem {
	
	static enum Color {RED, WHITE, BLUE};
	
	static void partition(Color[] A) {
		Color mid = Color.values()[1];
		
		int smaller = 0;
		int same = 0;
		int larger = A.length - 1;
		
		while (same <= larger) {
			if (A[same].ordinal() < mid.ordinal()) {
				swap(A, smaller, same);
				smaller++;
				same++;
			} else if (A[same].ordinal() > mid.ordinal()) {
				swap(A, same, larger);
				larger--;
			} else {
				same++;
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
		test(new Color[] {Color.BLUE, Color.BLUE, Color.WHITE, Color.RED, Color.WHITE});
		test(new Color[] {Color.WHITE, Color.BLUE, Color.BLUE, Color.RED, Color.RED});
	}

}
