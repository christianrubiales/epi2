package epi2._10sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoSortedArrays {
	
	static List<Integer> intersection(List<Integer> A, List<Integer> B) {
		List<Integer> result = new ArrayList<>();
		int x = 0;
		int y = 0;
		
		while (x < A.size() && y < B.size()) {
			if (A.get(x) == B.get(y)) {
				if (result.isEmpty() || (result.get(result.size() - 1) != A.get(x))) {
					result.add(A.get(x));
				}
				x++;
				y++;
			} else if (A.get(x) < B.get(y)) {
				x++;
			} else {
				y++;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(intersection(Arrays.asList(2,3,3,5,5,6,7,7,8,12), Arrays.asList(5,5,6,8,8,9,10,10)));//5,6,8
	}

}
