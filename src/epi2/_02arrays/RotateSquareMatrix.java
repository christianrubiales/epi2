package epi2._02arrays;

import java.util.Arrays;

public class RotateSquareMatrix {
	
	static Integer[][] rotateSquareMatrixClockwise(Integer[][] M) {
		int n = M.length-1;
		
		for (int i = 0; i <= n/2; i++) {
			for (int j = i; j < n - i; j++) {
				int x = M[i][j];

				M[i][j] = M[n-j][i];
				M[n-j][i] = M[n-i][n-j];
				M[n-i][n-j] = M[j][n-i];
				M[j][n-i] = x;
			}
		}
		
		return M;
	}
	
	static Integer[][] rotateSquareMatrixCounterClockwise(Integer[][] M) {
		int n = M.length-1;
		
		for (int i = 0; i <= n/2; i++) {
			for (int j = i; j < n - i; j++) {
				int x = M[i][j];

				M[i][j] = M[j][n-i];
				M[j][n-i] = M[n-i][n-j];
				M[n-i][n-j] = M[n-j][i];
				M[n-j][i] = x;
			}
		}
		
		return M;
	}

	// @see http://javabypatel.blogspot.in/2016/11/rotate-matrix-by-90-degrees-inplace.html
	static Integer[][] rotateSquareMatrixOld(Integer[][] M) {
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
	
	// @see https://discuss.leetcode.com/topic/6796/a-common-method-to-rotate-the-image
	static Integer[][] rotateSquareMatrixFlipTranspose(Integer[][] M) {
		int n = M.length-1;
		
		// flip vertically
		for (int i = 0; i <= n/2; i++) {
			for (int j = 0; j < M[i].length; j++) {
				Integer t = M[i][j];
				M[i][j] = M[n-i][j];
				M[n-i][j] = t;
			}
		}
		
		// transpose
		for (int i = 0; i < M.length; i++) {
			for (int j = i; j < M[i].length; j++) {
				Integer t = M[i][j];
				M[i][j] = M[j][i];
				M[j][i] = t;
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
	
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(rotateSquareMatrixClockwise(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		System.out.println(Arrays.deepToString(rotateSquareMatrixFlipTranspose(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		System.out.println(Arrays.deepToString(rotateSquareMatrixWithCopy(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		System.out.println(Arrays.deepToString(rotateSquareMatrixCounterClockwise(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}})));
		
		System.out.println(Arrays.deepToString(rotateSquareMatrixClockwise(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));
		System.out.println(Arrays.deepToString(rotateSquareMatrixFlipTranspose(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));
		System.out.println(Arrays.deepToString(rotateSquareMatrixWithCopy(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));
		System.out.println(Arrays.deepToString(rotateSquareMatrixCounterClockwise(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));
	}

}
