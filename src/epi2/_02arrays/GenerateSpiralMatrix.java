package epi2._02arrays;

import java.util.Arrays;

public class GenerateSpiralMatrix {
	
	// @see http://www.crazyforcode.com/print-square-matrix-spiral-form/
	// O(n^2)
	static Integer[][] generateMatrix(int n) {
		return null;
	}
	
	
	// O(n^2)
	static Integer[][] generateMatrix(int n, int m) {
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = m-1;
        Integer[][] M = new Integer[n][m];
        int i = 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j ++) {// right
            		M[rowStart][j] = i++;
            }
            rowStart++;
            
            for (int j = rowStart; j <= rowEnd; j ++) {// down
            		M[j][colEnd] = i++;
            }
            colEnd--;
            
            if (rowStart <= rowEnd) {// left
                for (int j = colEnd; j >= colStart; j --) {
                    M[rowEnd][j] = i++;
                }
            }
            rowEnd--;
            
            if (colStart <= colEnd) {// up
                for (int j = rowEnd; j >= rowStart; j --) {
                    M[j][colStart] = i++;
                }
            }
            colStart++;
        }
        
        return M;
	}

	public static void main(String[] args) {
//		System.out.println(Arrays.deepToString(generateMatrix(1)));
//		System.out.println(Arrays.deepToString(generateMatrix(2)));
//		System.out.println(Arrays.deepToString(generateMatrix(3)));
//		System.out.println(Arrays.deepToString(generateMatrix(4)));
//		System.out.println(Arrays.deepToString(generateMatrix(5)));
		
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				System.out.println(i + "x" + j);
				System.out.println(Arrays.deepToString(generateMatrix(i, j)));
				System.out.println();
			}
		}
		
	}

}
