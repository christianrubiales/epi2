package epi2._02arrays;

import java.util.Arrays;

public class AntiDiagonals {
	
	static Integer[][] antiDiagonals(int[][] M) {
		Integer[][] result = new Integer[2 * M.length - 1][];
		
		for (int i = 0; i < M.length; i++) {
			Integer[] line = new Integer[i+1];
			result[i] = line;
			for (int j = 0; j <= i; j++) {
				line[j] = M[j][i-j];
			}
		}
		
		for (int i = 1; i < M.length; i++) {
			Integer[] line = new Integer[M.length - i];
			result[M.length + i - 1] = line;
			int k = 1;
			for (int j = i; j < M.length; j++) {
				line[j-i] = M[j][M.length-k];
				k++;
			}
		}
		
		return result;
	}
	
	static Integer[][] antiDiagonals(int n) {
		Integer[][] result = new Integer[2 * n - 1][];
		
		result[0] = new Integer[] {1};
		for (int i = 2; i <= n; i++) {
			Integer[] line = new Integer[i];
			result[i-1] = line;
			line[0] = i;
			for (int j = 1; j < i; j++) {
				line[j] = line[j-1] + (n-1);
			}
		}
		
		for (int i = 0; i < n-1; i++) {
			Integer[] line = new Integer[n-i-1];
			result[n+i] = line;
			line[0] = n*(i+2);
			for (int j = 1; j < line.length; j++) {
				line[j] = line[j-1] + n-1;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		int[][] M = new int[][] {
			{1}
		};
		System.out.println(Arrays.deepToString(antiDiagonals(M)));
		
		M = new int[][] {
			{1,2},
			{3,4},
		};
		System.out.println(Arrays.deepToString(antiDiagonals(M)));
		
		M = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9},
		};
		System.out.println(Arrays.deepToString(antiDiagonals(M)));
		
		M = new int[][] {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		};
		System.out.println(Arrays.deepToString(antiDiagonals(M)));
		
		M = new int[][] {
			{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15},
			{16,17,18,19,20},
			{21,22,23,24,25}
		};
		System.out.println(Arrays.deepToString(antiDiagonals(M)));
		
		M = new int[][] {
			{1,2,3,4,5,6},
			{7,8,9,10,11,12},
			{13,14,15,16,17,18},
			{19,20,21,22,23,24},
			{25,26,27,28,29,30},
			{31,32,33,34,35,36}
		};
		System.out.println(Arrays.deepToString(antiDiagonals(M)));
		
		for (int i = 1; i < 7; i++) {
			System.out.println(Arrays.deepToString(antiDiagonals(i)));
		}
	}

}
