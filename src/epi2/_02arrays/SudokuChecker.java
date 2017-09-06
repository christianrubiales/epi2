package epi2._02arrays;

import java.util.HashSet;
import java.util.Set;

public class SudokuChecker {
	
	// straightforward, careful with indices
	// duplicate checker must be flexible with sizes
	// O(n^2)
	static boolean check(int[][] board) {
		// check rows
		for (int i = 0; i < board.length; i++) {
			if (hasDuplicates(board, i, 0, i, board.length - 1)) {
				return false;
			}
		}
		
		// check columns
		for (int j = 0; j < board.length; j++) {
			if (hasDuplicates(board, 0, j, board.length - 1, j)) {
				return false;
			}
		}
		
		// check subgrids, exclusive with upper boundaries
		int root = (int) Math.sqrt(board.length);
		for (int i = 0; i < root; i++) {
			for (int j = 0; j < root; j++) {
				if (hasDuplicates(board, (i*root), (j*root), (i*root) + root - 1, (j*root) + root - 1)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// inclusive
	static boolean hasDuplicates(int[][] board, int startRow, int startColumn, int endRow, int endColumn) {
		Set<Integer> set = new HashSet<>();
		
		for (int i = startRow; i <= endRow; i++) {
			for (int j = startColumn; j <= endColumn; j++) {
				if (set.contains(board[i][j])) {
					return true;
				} else {
					set.add(board[i][j]);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// The example from Wikipedia
		int[][] board = new int[][]{ 
	        {5, 3, 4, 6, 7, 8, 9, 1, 2}, 
	        {6, 7, 2, 1, 9, 5, 3, 4, 8},
	        {1, 9, 8, 3, 4, 2, 5, 6, 7},
	        {8, 5, 9, 7, 6, 1, 4, 2, 3},
	        {4, 2, 6, 8, 5, 3, 7, 9, 1},
	        {7, 1, 3, 9, 2, 4, 8, 5, 6},
	        {9, 6, 1, 5, 3, 7, 2, 8, 4},
	        {2, 8, 7, 4, 1, 9, 6, 3, 5},
	        {3, 4, 5, 2, 8, 6, 1, 7, 9}
	    };
	    
		System.out.println(check(board));
		board = new int[][]{
			{1,2,3,4},
			{3,4,2,1},
			{4,3,1,2},
			{2,1,4,3},
	    };
		System.out.println(check(board));
	}

}
