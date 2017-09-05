package epi2._02arrays;

public class LongestHomogenousSubarray {
	
	// similar to majority element
	// O(n)
	static int longestHomogenousSubarray(int[] a) {
		if (a.length == 0) {
			return 0;
		}
		
		int max = 1;
		int count = 1;
		int current = a[0];
		
		for (int i = 1; i < a.length; i++) {
			if (a[i] == current) {
				count++;
				max = Math.max(max, count);
			} else {
				count = 1;
				current = a[i];
			}
		}
		
		return max;
	}
	
	static void print(int[] a, int max) {
		System.out.print("array: [");
		for (int x : a) {
			System.out.print(x + ",");
		}
		System.out.println("], max: " + max);
	}

	public static void main(String[] args) {
		int[] a = new int[] {3,3,1,3,4,3,3,3,5,3,3};
		print(a, longestHomogenousSubarray(a));//3
		print(new int[] {}, longestHomogenousSubarray(new int[] {}));//0
	}

}
