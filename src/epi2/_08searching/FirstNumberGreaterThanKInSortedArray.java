package epi2._08searching;

/**
 * Refer to page 13, then remove this sentence.
 */
public class FirstNumberGreaterThanKInSortedArray {
	
	static int getFirstNumber(int k, int[] array) {
		return 0;
	}
	
	static void print(int k, int[] array, int first) {
		System.out.print("k: " + k + ", array: [");
		
		for (int x : array) {
			System.out.print(x + ",");
		}
		
		System.out.print("], first: " + first);
	}

	public static void main(String[] args) {
		print(3, new int[]{1,2,3,4,5}, getFirstNumber(3, new int[]{1,2,3,4,5}));
	}

}
