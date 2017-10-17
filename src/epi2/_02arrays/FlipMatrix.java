package epi2._02arrays;

import java.util.Arrays;

public class FlipMatrix {
	
	static Integer[][] flipMatrixVertically(Integer[][] M) {
		for (int i = 0; i < M.length / 2; i++) {
			for (int j = 0; j < M[i].length; j++) {
				int t = M[i][j];
				M[i][j] = M[M.length - i - 1][j];
				M[M.length - i - 1][j] = t;
			}
		}
		
		return M;
	}
	
	static Integer[][] flipMatrixHorizontally(Integer[][] M) {
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length / 2; j++) {
				int t = M[i][j];
				M[i][j] = M[i][M[i].length - j - 1];
				M[i][M[i].length - j - 1] = t;
			}
		}
		
		return M;
	}
	
	static Integer[][] flipMatrixDiagonally(Integer[][] M) {
		for (int i = 0; i < M.length; i++) {
			for (int j = i; j < M.length; j++) {
				int t = M[i][j];
				M[i][j] = M[j][i];
				M[j][i] = t;
			}
		}
		
		return M;
	}
	
	static Integer[][] flipMatrixAntidiagonally(Integer[][] M) {
		int n = M.length - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				int t = M[i][j];
				M[i][j] = M[n - j][n - i];
				M[n - j][n - i] = t;
			}
		}

		return M;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(flipMatrixVertically(new Integer[][] {{1,2,3,4}})));//1,2,3,4
		System.out.println(Arrays.deepToString(flipMatrixVertically(new Integer[][] {{1,2,3},{4,5,6}})));
		System.out.println(Arrays.deepToString(flipMatrixVertically(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		System.out.println(Arrays.deepToString(flipMatrixVertically(new Integer[][] {{1},{2},{3},{4}})));//4,3,2,1
		
		System.out.println(Arrays.deepToString(flipMatrixHorizontally(new Integer[][] {{1,2,3,4}})));//4,3,2,1
		System.out.println(Arrays.deepToString(flipMatrixHorizontally(new Integer[][] {{1,2,3},{4,5,6}})));
		System.out.println(Arrays.deepToString(flipMatrixHorizontally(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		System.out.println(Arrays.deepToString(flipMatrixHorizontally(new Integer[][] {{1},{2},{3},{4}})));//1,2,3,4
		
		System.out.println(Arrays.deepToString(flipMatrixDiagonally(new Integer[][] {{1}})));
		System.out.println(Arrays.deepToString(flipMatrixDiagonally(new Integer[][] {{1,2},{3,4}})));
		System.out.println(Arrays.deepToString(flipMatrixDiagonally(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		System.out.println(Arrays.deepToString(flipMatrixDiagonally(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));

		System.out.println(Arrays.deepToString(flipMatrixAntidiagonally(new Integer[][] {{1}})));
		System.out.println(Arrays.deepToString(flipMatrixAntidiagonally(new Integer[][] {{1,2},{3,4}})));
		System.out.println(Arrays.deepToString(flipMatrixAntidiagonally(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		System.out.println(Arrays.deepToString(flipMatrixAntidiagonally(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));
	}
}
