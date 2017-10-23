package epi2._02arrays;

import java.util.Arrays;

public class RotateNonSquareMatrix {
	
	static Integer[][] rotateClockwise(Integer[][] M) {
		Integer[][] N = new Integer[M[0].length][M.length];
		
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length; j++) {
				N[j][M.length - i - 1] = M[i][j];
			}
		}
		
		return N;
	}
	
	static Integer[][] rotateCounterClockwise(Integer[][] M) {
		Integer[][] N = new Integer[M[0].length][M.length];
		
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length; j++) {
				N[M[i].length - j - 1][i] = M[i][j];
			}
		}
		
		return N;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(rotateClockwise(new Integer[][] {{1,2,3},{4,5,6}})));
		System.out.println(Arrays.deepToString(rotateClockwise(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}})));
		
		System.out.println(Arrays.deepToString(rotateCounterClockwise(new Integer[][] {{1,2,3},{4,5,6}})));
		System.out.println(Arrays.deepToString(rotateCounterClockwise(new Integer[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}})));
	}

}
