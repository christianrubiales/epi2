package epi2._08searching;

public class FirstOccurrenceOfKInSortedArray {
	
	static int getFirstOccurrence(int[] A, int k) {
		int low = 0;
		int high = A.length - 1;
		int result = -1;
		
		while (low <= high) {
			int mid = low + (high-low)/2;
			
			if (A[mid] > k) {
				high = mid - 1;
			} else if (A[mid] < k) {
				low = mid + 1;
			} else {
				result = mid;
				high = mid - 1;
			}
		}
		
		return result;
	}
	
	static void print(int k, int[] array, int first) {
		System.out.print("k: " + k + ", array: [");
		
		for (int x : array) {
			System.out.print(x + ",");
		}
		
		System.out.println("], first: " + first);
	}

	public static void main(String[] args) {
		print(3, new int[]{1,2,3,3,3,3,4,5}, getFirstOccurrence(new int[]{1,2,3,3,3,3,4,5}, 3));//2
		print(108, new int[]{-14,-10,2,108,108,243,285,285,285,401}, 
				getFirstOccurrence(new int[]{-14,-10,2,108,108,243,285,285,285,401}, 108));//3
		print(285, new int[]{-14,-10,2,108,108,243,285,285,285,401}, 
				getFirstOccurrence(new int[]{-14,-10,2,108,108,243,285,285,285,401}, 285));//6
		print(-10, new int[]{-14,-10,2,108,108,243,285,285,285,401}, 
				getFirstOccurrence(new int[]{-14,-10,2,108,108,243,285,285,285,401}, -10));//1
	}

}
