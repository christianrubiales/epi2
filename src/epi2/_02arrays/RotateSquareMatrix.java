package epi2._02arrays;

import java.util.Arrays;

public class RotateSquareMatrix {
	
	// @see http://javabypatel.blogspot.in/2016/11/rotate-matrix-by-90-degrees-inplace.html
	static Integer[][] rotateSquareMatrix(Integer[][] M) {
		int n = M.length-1;
		
		for (int i = 0; i <= n/2; i++) {
			for (int j = i; j < n - i; j++) {

				int a = M[i][j];
				int b = M[j][n-i];
				int c = M[n-i][n-j];
				int d = M[n-j][i];

				M[j][n-i] = a;
				M[n-i][n-j] = b;
				M[n-j][i] = c;
				M[i][j] = d;
			}
		}
		
		return M;
	}
	
	static Integer[][] rotateSquareMatrixWithCopy(Integer[][] M) {
		int n = M.length;
		Integer[][] N = new Integer[M.length][M.length];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				N[j][n-1-i] = M[i][j];
			}
		}
		
		return N;
	}
	
	// @see https://en.wikipedia.org/wiki/In-place_matrix_transposition#Square_matrices
	static Integer[][] rotateSquareMatrixBySwapping(Integer[][] M) {
		int n = M.length;
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int t = M[i][j];
				M[i][j] = M[j][i];
				M[j][i] = t;
			}
		}
		
		return M;
	}

	// @see https://rosettacode.org/wiki/Matrix_transposition#Java
	// nth row becomes nth column (SAME AS) nth column becomes nth row
	static Integer[][] transposeMatrix(Integer[][] M) {
		Integer[][] N = new Integer[M[0].length][M.length];
		
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				N[j][i] = M[i][j];
			}
		}
		
		return N;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(rotateSquareMatrix(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		System.out.println(Arrays.deepToString(rotateSquareMatrixWithCopy(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		System.out.println(Arrays.deepToString(rotateSquareMatrixBySwapping(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		System.out.println(Arrays.deepToString(transposeMatrix(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		
		System.out.println(Arrays.deepToString(rotateSquareMatrix(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));
		System.out.println(Arrays.deepToString(rotateSquareMatrixWithCopy(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));
		System.out.println(Arrays.deepToString(rotateSquareMatrixBySwapping(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));
		System.out.println(Arrays.deepToString(transposeMatrix(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));
		
		System.out.println(Arrays.deepToString(transposeMatrix(new Integer[][] {{1,1,1,1},{2,4,8,16},{3,9,27,81},{4,16,64,256},{5,25,125,625}})));
	}

}
