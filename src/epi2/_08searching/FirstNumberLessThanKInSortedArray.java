package epi2._08searching;

/**
 * FIXME
 * @see https://stackoverflow.com/a/6554035/2256169
 */
public class FirstNumberLessThanKInSortedArray {
	
	// return the index to be clearer
	static int getFirstLesser(int[] A, int k) {
		int low = 0;
		int high = A.length - 1;
		
		while (low < high && low > 0) {
			int mid = low + (high - low)/2;
			
			if (A[mid] >= k) {
				high = mid-1;
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
//		System.out.println(getFirstLesser(new int[] {1}, 1));//-1
//		System.out.println(getFirstLesser(new int[] {1,1}, 1));//-1
//		System.out.println(getFirstLesser(new int[] {1,1,1}, 1));//-1
//		System.out.println(getFirstLesser(new int[] {1,1,1,1}, 1));//-1
//		System.out.println(getFirstLesser(new int[] {1,1,1,1,1}, 1));//-1

//		System.out.println(getFirstLesser(new int[] {0,1}, 1));//-1
//		System.out.println(getFirstLesser(new int[] {0,0,1}, 1));//-1
//		System.out.println(getFirstLesser(new int[] {0,0,0,1}, 1));//-1
//		System.out.println(getFirstLesser(new int[] {0,0,0,0,1}, 1));//-1
//		System.out.println(getFirstLesser(new int[] {0,0,0,0,0,1}, 1));//-1
////		
//		System.out.println(getFirstLesser(new int[] {1,2}, 1));//1
//		System.out.println(getFirstLesser(new int[] {1,2,2}, 1));//1
//		System.out.println(getFirstLesser(new int[] {1,2,2,2}, 1));//1
//		System.out.println(getFirstLesser(new int[] {1,2,2,2,2}, 1));//1
//		System.out.println(getFirstLesser(new int[] {1,2,2,2,2}, 1));//1
//		
//		System.out.println(getFirstLesser(new int[] {1,1,2}, 1));//2
//		System.out.println(getFirstLesser(new int[] {1,1,2,2}, 1));//2
//		System.out.println(getFirstLesser(new int[] {1,1,2,2,2}, 1));//2
//		System.out.println(getFirstLesser(new int[] {1,1,2,2,2,2}, 1));//2
//		System.out.println(getFirstLesser(new int[] {1,1,2,2,2,2}, 1));//2
	}

}
