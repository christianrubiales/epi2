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
	
	static Integer[][] transposeOrFlipSquareMatrixDiagonally(Integer[][] M) {
		for (int i = 0; i < M.length; i++) {
			for (int j = i; j < M.length; j++) {
				int t = M[i][j];
				M[i][j] = M[j][i];
				M[j][i] = t;
			}
		}
		
		return M;
	}
	
	static Integer[][] transposeOrFlipNonSquareMatrixDiagonally(Integer[][] M) {
		Integer[][] N = new Integer[M[0].length][M.length];
		
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				N[j][i] = M[i][j];
			}
		}
		
		return N;
	}
	
	static Integer[][] flipSquareMatrixAntidiagonally(Integer[][] M) {
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
		
		System.out.println(Arrays.deepToString(transposeOrFlipSquareMatrixDiagonally(new Integer[][] {{1}})));
		System.out.println(Arrays.deepToString(transposeOrFlipSquareMatrixDiagonally(new Integer[][] {{1,2},{3,4}})));
		System.out.println(Arrays.deepToString(transposeOrFlipSquareMatrixDiagonally(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		System.out.println(Arrays.deepToString(transposeOrFlipSquareMatrixDiagonally(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));

		System.out.println(Arrays.deepToString(transposeOrFlipNonSquareMatrixDiagonally(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		System.out.println(Arrays.deepToString(transposeOrFlipNonSquareMatrixDiagonally(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));
		System.out.println(Arrays.deepToString(transposeOrFlipNonSquareMatrixDiagonally(new Integer[][] {{1,1,1,1},{2,4,8,16},{3,9,27,81},{4,16,64,256},{5,25,125,625}})));
		System.out.println(Arrays.deepToString(transposeOrFlipNonSquareMatrixDiagonally(new Integer[][] {{1,1,1,1},{2,2,2,2},{3,3,3,3}})));
		System.out.println(Arrays.deepToString(transposeOrFlipNonSquareMatrixDiagonally(new Integer[][] {{1,2,3,4},{1,2,3,4},{1,2,3,4}})));
		System.out.println(Arrays.deepToString(transposeOrFlipNonSquareMatrixDiagonally(new Integer[][] {{1,1,1},{2,2,2},{3,3,3},{4,4,4}})));

		System.out.println(Arrays.deepToString(flipSquareMatrixAntidiagonally(new Integer[][] {{1}})));
		System.out.println(Arrays.deepToString(flipSquareMatrixAntidiagonally(new Integer[][] {{1,2},{3,4}})));
		System.out.println(Arrays.deepToString(flipSquareMatrixAntidiagonally(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		System.out.println(Arrays.deepToString(flipSquareMatrixAntidiagonally(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));
	}
}
