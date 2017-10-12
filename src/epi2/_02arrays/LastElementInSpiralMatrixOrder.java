package epi2._02arrays;

// @see http://talk.elementsofprogramminginterviews.com/t/problem-6-18-variant-the-last-element-in-spiral-order-for-a-m-x-n-2d-array/279/2
public class LastElementInSpiralMatrixOrder {
	
	static int lastElement(int[][] M) {
		int x = M.length/2;
		int y = M[0].length/2;
		
//		x = M.length % 2 == 0 ? x-1 : x;
		y = M[0].length % 2 == 0 ? y-1 : y;
		
		return M[x][y];
	}

	public static void main(String[] args) {
		int[][] M = new int[][] {
			{1,2},
			{3,4}
		};
		System.out.println(lastElement(M));//3
		
		M = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		System.out.println(lastElement(M));//5
		
		M = new int[][] {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		};
		System.out.println(lastElement(M));//7
		
		M = new int[][] {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		};
		System.out.println(lastElement(M));//10
	}

}
