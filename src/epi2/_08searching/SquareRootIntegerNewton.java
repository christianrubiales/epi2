package epi2._08searching;

public class SquareRootIntegerNewton {
	
	static int sqrt(int n) {
		long r = n;
		
		while (r * r > n) {
			r = (r + n/r) / 2;
		}
		
		return (int) r;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + ": " +sqrt(i));
		}
	}

}
