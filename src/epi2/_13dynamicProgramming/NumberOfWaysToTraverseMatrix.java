package epi2._13dynamicProgramming;

// @see http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
public class NumberOfWaysToTraverseMatrix {
	
	static int numberOfWays(int n, int m) {
		int[][] count = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			count[i][0] = 1;
		}
		
		for (int j = 0; j < m; j++) {
			count[0][j] = 1;
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				count[i][j] = count[i-1][j] + count[i][j-1];
			}
		}
		
		return count[n-1][m-1];
	}

	public static void main(String[] args) {
		System.out.println(numberOfWays(5, 5));// 70
	}

}
