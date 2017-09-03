package epi2._01primitiveTypes;

import java.util.Arrays;

/**
 * Use Euclidean distance formula with Sorting and Hypoteneuse formula (a^2 + b^2 = c^2)
 * Use epsilon for comparison of equality of floating point numbers
 */
public class IsRectangle {
	
	static boolean isRectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		double d1 = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		double d2 = Math.sqrt((x1-x3)*(x1-x3) + (y1-y3)*(y1-y3));
		double d3 = Math.sqrt((x1-x4)*(x1-x4) + (y1-y4)*(y1-y4));
		
		double[] a = new double[] {d1, d2, d3};
		Arrays.sort(a);
		
		return a[2]*a[2] - (a[0]*a[0] + a[1]*a[1]) < 1e-9d;
	}

	public static void main(String[] args) {
		System.out.println(isRectangle(0, 0, 0, 1, 1, 1, 1, 0));// true
		System.out.println(isRectangle(0, 0, 0, 1, 1, 1, 1, 8));// false
		System.out.println(isRectangle(0, 0, 0, 1, 1, 1, 1, 0));// true
		System.out.println(isRectangle(47, 16, 8, 20, 39, 2, 16, 34));// true //http://www.mathopenref.com/coordrectangle.html
	}

}
