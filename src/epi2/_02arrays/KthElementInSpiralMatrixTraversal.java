package epi2._02arrays;

// FIXME
public class KthElementInSpiralMatrixTraversal {

	static int kthElement(int M[][], int k) {
		return kthElement(M, k, 0, M.length-1, 0, M[0].length - 1);
	}
	
	static int kthElement(int M[][], int k, int firstRow, int lastRow, int firstCol, int lastCol) {
		int n = lastRow - firstRow  + 1;
		int m = lastCol - firstCol  + 1;
		
	    /* Element is in first row */
	    if (k <= m)
	        return M[firstRow][k-1];
	 
	    /* Element is in last column */
	    if (k <= (m+n-1))
	        return M[(k-m)][lastCol];
	 
	    /* Element is in last row */
	    if (k <= (m+n-1+m-1))
	        return M[lastRow][m-1-(k-(m+n-1))];
	 
	    /* Element is in first column */
	    if (k <= (m+n-1+m-1+n-2))
	        return M[n-1-(k-(m+n-1+m-1))][firstCol];
	    
	    return kthElement(M, k-(n*2+m*2-4), firstRow+1, lastRow-1, firstCol+1, lastCol-1);
	}

	public static void main(String[] args) {
		int[][] M = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		for (int i = 1; i <= 9; i++) {
			System.out.println(kthElement(M, i));
		}
		System.out.println();
		
		M = new int[][] {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		};
		for (int i = 1; i <= 12; i++) {
			System.out.println(kthElement(M, i));
		}
	}

}
