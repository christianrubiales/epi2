package epi2._02arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @see https://en.wikipedia.org/wiki/Pascal%27s_triangle#Calculating_a_row_or_diagonal_by_itself
 */
public class PascalsTriangleLastRow {

	static List<Integer> pascalsTriangleLastRow(int n) {
		List<Integer> row = new ArrayList<>();
		
		int prev = 1;
		for (int k = 1; k <= n + 1; k++) {
			row.add(prev);
			prev = prev * (n + 1 - k) / k;
		}
		
		return row;
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 20; i++) {
			System.out.println(pascalsTriangleLastRow(i));
		}
	}

}
