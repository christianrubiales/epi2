package epi2._08searching;

/**
 * @see https://stackoverflow.com/a/6554035/2256169
 */
public class FirstNumberGreaterThanKInSortedArray {
	
	// return the index to be clearer
	static int getFirstGreater(int[] A, int k) {
		int low = 0;
		int high = A.length - 1;
		
		while (low < high) {
			int mid = low + (high - low)/2;
			
			if (A[mid] <= k) {
				low = mid+1;
			} else {
				high = mid;
			}
		}
		
		if (k >= A[high]) {
			return -1;
		} else {
			return high;
		}
	}

	public static void main(String[] args) {
		System.out.println(getFirstGreater(new int[] {1}, 1));//-1
		System.out.println(getFirstGreater(new int[] {1,1}, 1));//-1
		System.out.println(getFirstGreater(new int[] {1,1,1}, 1));//-1
		System.out.println(getFirstGreater(new int[] {1,1,1,1}, 1));//-1
		System.out.println(getFirstGreater(new int[] {1,1,1,1,1}, 1));//-1
		
		System.out.println(getFirstGreater(new int[] {0,1}, 1));//-1
		System.out.println(getFirstGreater(new int[] {0,0,1}, 1));//-1
		System.out.println(getFirstGreater(new int[] {0,0,0,1}, 1));//-1
		System.out.println(getFirstGreater(new int[] {0,0,0,0,1}, 1));//-1
		System.out.println(getFirstGreater(new int[] {0,0,0,0,0,1}, 1));//-1
		
		System.out.println(getFirstGreater(new int[] {1,2}, 1));//1
		System.out.println(getFirstGreater(new int[] {1,2,2}, 1));//1
		System.out.println(getFirstGreater(new int[] {1,2,2,2}, 1));//1
		System.out.println(getFirstGreater(new int[] {1,2,2,2,2}, 1));//1
		System.out.println(getFirstGreater(new int[] {1,2,2,2,2}, 1));//1
		
		System.out.println(getFirstGreater(new int[] {1,1,2}, 1));//2
		System.out.println(getFirstGreater(new int[] {1,1,2,2}, 1));//2
		System.out.println(getFirstGreater(new int[] {1,1,2,2,2}, 1));//2
		System.out.println(getFirstGreater(new int[] {1,1,2,2,2,2}, 1));//2
		System.out.println(getFirstGreater(new int[] {1,1,2,2,2,2}, 1));//2
	}

}
