package epi2._08searching;

public class SquareRootIntegerBinarySearch {
	
	static int sqrt(int n) {
		long left = 0;
		long right = n;
		
		while (left <= right) {
			long mid = left + ((right-left)/2);
			long squared = mid * mid;
			
			if (squared <= n) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return (int) left - 1;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + ": " +sqrt(i));
		}
	}

}
