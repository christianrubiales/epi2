package epi2._02arrays;

// @see http://javabypatel.blogspot.in/2016/11/rotate-matrix-by-90-degrees-inplace.html
public class RotateMatrixBy90Degree {
	 public static void main(String[] args) {
		  new RotateMatrixBy90Degree();
		 }
		 
		 public RotateMatrixBy90Degree() {
		  int[][] matrix = {
		   {1,  2,  3,  4},
		   {5,  6,  7,  8},
		   {9,  10, 11, 12},
		   {13, 14, 15, 16}
		  };
		  rotateMatrixInplace(matrix);
		  printMatrix(matrix);
		 }
		 
		 public void rotateMatrixInplace(int[][] matrix) {
		  int length = matrix.length-1;
		   
		  for (int i = 0; i <= (length)/2; i++) {
		      for (int j = i; j < length-i; j++) {
		        
		       //Coordinate 1
		       int p1 = matrix[i][j];
		        
		       //Coordinate 2
		       int p2 = matrix[j][length-i];
		        
		       //Coordinate 3
		       int p3 = matrix[length-i][length-j];
		        
		       //Coordinate 4
		       int p4 = matrix[length-j][i];
		        
		       //Swap values of 4 coordinates.
		       matrix[j][length-i] = p1;
		       matrix[length-i][length-j] = p2;
		       matrix[length-j][i] = p3;
		       matrix[i][j] = p4;
		      }
		  }
		 }
		 
		 private static void printMatrix(int[][] matrix){
		  for (int i = 0; i < matrix.length; i++) {
		   for (int j = 0; j < matrix[0].length; j++) {
		    System.out.print(matrix[i][j] + " "); 
		   }
		   System.out.println();
		  }
		 }
}
