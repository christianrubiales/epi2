package epi2._02arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderOfMatrix {
	
	// @see https://discuss.leetcode.com/topic/3713/super-simple-and-easy-to-understand-solution/2
	static List<Integer> spiralOrder(Integer[][] M) {
        List<Integer> order = new ArrayList<Integer>();
        
        if (M.length == 0) {
            return order;
        }
        
        int rowStart = 0;
        int rowEnd = M.length-1;
        int colStart = 0;
        int colEnd = M[0].length - 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j++) {// right
                order.add(M[rowStart][j]);
            }
            rowStart++;
            
            for (int j = rowStart; j <= rowEnd; j++) {// down
                order.add(M[j][colEnd]);
            }
            colEnd--;
            
            if (rowStart <= rowEnd) {// left
                for (int j = colEnd; j >= colStart; j--) {
                    order.add(M[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colStart <= colEnd) {// up
                for (int j = rowEnd; j >= rowStart; j--) {
                    order.add(M[j][colStart]);
                }
            }
            colStart++;
        }
        
        return order;
	}

	public static void main(String[] args) {
		Integer[][] M = new Integer[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		System.out.println(spiralOrder(M));
		
		M = new Integer[][] {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		};
		System.out.println(spiralOrder(M));
		
		M = new Integer[][] {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16},
			{17,18,19,20}
		};
		System.out.println(spiralOrder(M));
	}

}
