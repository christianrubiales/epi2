package epi2._02arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncrementIntegerAsList {
	
	static List<Integer> increment(List<Integer> a) {
		
		// increment last element
		int n = a.size() - 1;
		a.set(n, a.get(n) + 1);
		
		// only increment next higher digit if there is a carry
		// this will only be needed if smallest digit was 9 and incremented
		for (int i = n; i > 0 && a.get(i) == 10; i--) {
			a.set(i, 0);
			a.set(i - 1, a.get(i - 1) + 1);
		}
		
		// split 10 into 1 and 0
		if (a.get(0) == 10) {
			a.set(0, 0);
			a.add(0, 1);
		}
		
		return a;
	}

	public static void main(String[] args) {
		System.out.println(increment(new ArrayList<>(Arrays.asList(9))));//1,0
		System.out.println(increment(new ArrayList<>(Arrays.asList(1,2,3))));//1,2,4
		System.out.println(increment(new ArrayList<>(Arrays.asList(1,2,9))));//1,3,0
		System.out.println(increment(new ArrayList<>(Arrays.asList(8,9,9))));//9,0,0
	}

}
