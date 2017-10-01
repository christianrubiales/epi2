package epi2._02arrays;

import java.util.Arrays;

public class SpiralMatrixFromOrdering {
	
	static Integer[][] generateMatrix(Integer[] order) {
		int n = (int) Math.sqrt(order.length);
		return generateMatrix(order, n, n);
	}
	
	static Integer[][] generateMatrix(Integer[] order, int n, int m) {
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = m-1;
        Integer[][] M = new Integer[n][m];
        int i = 0;
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j ++) {// right
            		M[rowStart][j] = order[i++];
            }
            rowStart++;
            
            for (int j = rowStart; j <= rowEnd; j ++) {// down
            		M[j][colEnd] = order[i++];
            }
            colEnd--;
            
            if (rowStart <= rowEnd) {// left
                for (int j = colEnd; j >= colStart; j --) {
                    M[rowEnd][j] = order[i++];
                }
            }
            rowEnd--;
            
            if (colStart <= colEnd) {// right
                for (int j = rowEnd; j >= rowStart; j --) {
                    M[j][colStart] = order[i++];
                }
            }
            colStart++;
        }
        
        return M;
	}

	public static void main(String[] args) {
		Integer[] order = new Integer[] {1, 2, 3, 6, 9, 8, 7, 4, 5};
		System.out.println(Arrays.deepToString(generateMatrix(order, 3, 3)));
		System.out.println(Arrays.deepToString(generateMatrix(order)));
		
		order = new Integer[] {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.deepToString(generateMatrix(order, 3, 3)));
		System.out.println(Arrays.deepToString(generateMatrix(order)));
		
		order = new Integer[] {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
		System.out.println(Arrays.deepToString(generateMatrix(order, 3, 4)));
	}

}
