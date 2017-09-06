package epi2._02arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	
	// draw triangle as left-aligned
	// if cell is the first or last column, the value is 1
	// else the value is the sum of the cell above it and the cell to the left of that
	static List<List<Integer>> pascalsTriangle(int n) {
		List<List<Integer>> triangle = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			List<Integer> row = new ArrayList<>(i);
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					row.add(j, triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
				}
			}
			triangle.add(row);
		}
		
		return triangle;
	}

	public static void main(String[] args) {
		System.out.println(pascalsTriangle(0));
		System.out.println(pascalsTriangle(1));
		System.out.println(pascalsTriangle(2));
		System.out.println(pascalsTriangle(3));
		System.out.println(pascalsTriangle(4));
		System.out.println(pascalsTriangle(5));
		System.out.println(pascalsTriangle(6));
		System.out.println(pascalsTriangle(7));
		System.out.println(pascalsTriangle(8));
		System.out.println(pascalsTriangle(9));
		System.out.println(pascalsTriangle(10));
	}

}
