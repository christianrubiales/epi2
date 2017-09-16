package epi2._02arrays;

import java.util.Arrays;

public class DutchNationalFlagProblem {
	
	static enum Color {RED, WHITE, BLUE};
	
	static void partition(Color[] A) {
		Color mid = Color.values()[1];
		
		int smaller = 0;
		int equal = 0;
		int greater = A.length - 1;
		
		while (equal <= greater) {
			if (A[equal].ordinal() < mid.ordinal()) {
				swap(A, smaller, equal);
				smaller++;
				equal++;
			} else if (A[equal].ordinal() > mid.ordinal()) {
				swap(A, equal, greater);
				greater--;
			} else {
				equal++;
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
		System.out.print(Arrays.deepToString(A));
	}

	public static void main(String[] args) {
		test(new Color[] {Color.BLUE, Color.BLUE, Color.WHITE, Color.RED, Color.WHITE});
	}

}
