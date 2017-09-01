package epi2._00bonus;

/**
 * Sort alternating: a[0] <= a[1] >= a[2] <= a[3] >= a[4] <= a[5] >= ...
 * Page 33
 * Swap a[i] and a[i+1] if i is even and a[i] > a[i+1]
 * Swap a[i] and a[i+1] if i is odd and a[i] < a[i+1]
 * O(n)
 */
public class SortAlternatingByOddEvenSwapping {
	
	static int[] alternating(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (i % 2 == 0) {
				if (a[i] > a[i+1]) {
					swap(a, i, i+1);
				}
			} else if (a[i] < a[i+1]) {
				swap(a, i, i+1);
			}
		}
		
		return a;
	}
	
	static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	static void print(String label, int[] array) {
		System.out.print(label + ": [");
		for (int a : array) {
			System.out.print(a + ",");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		int[] array = new int[] {10,9,8,7,6,5,4,3,2,1};
		print("array", array);
		print("alternating", alternating(array));
		
		array = new int[] {3,5,4,8,6,2,7,9,1,10};
		print("array", array);
		print("alternating", alternating(array));
	}

}
