package epi2._02arrays;

import java.util.Arrays;

public class GenerateSpiralMatrix {
	
	static Integer[][] generateMatrix(int n) {
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        Integer[][] M = new Integer[n][n];
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
            
            if (colStart <= colEnd) {// right
                for (int j = rowEnd; j >= rowStart; j --) {
                    M[j][colStart] = i++;
                }
            }
            colStart++;
        }
        
        return M;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(generateMatrix(3)));
		System.out.println(Arrays.deepToString(generateMatrix(4)));
		System.out.println(Arrays.deepToString(generateMatrix(5)));
	}

}
