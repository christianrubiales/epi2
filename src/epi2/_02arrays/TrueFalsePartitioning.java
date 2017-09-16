package epi2._02arrays;

import java.util.Arrays;

public class TrueFalsePartitioning {
	
	// use two pointers, swapping the front entry with the back if not true
	// O(n)
	static void trueFalsePartition(Boolean[] a) {
		int i = 0; // front pointer
		int j = a.length - 1; // back pointer
		
		while (i < j) {
			// swap with back pointer if front pointer is not true
			if (!a[i]) {
				Boolean t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
			
			// increment front pointer if already true
			if (a[i]) {
				i++;
			}

			// decrement back pointer if already false
			if (!a[j]) {
				j--;
			}
		}
	}
	
	static void test(Boolean[] A) {
		trueFalsePartition(A);
		System.out.println(Arrays.deepToString(A));
	}
	
	public static void main(String[] args) {
		test(new Boolean[] {false, true});
		test(new Boolean[] {true, false});
		test(new Boolean[] {false, true, false, true, false, true, false, true});
		test(new Boolean[] {true, false, false, true, false, true, false, true});
	}

}
