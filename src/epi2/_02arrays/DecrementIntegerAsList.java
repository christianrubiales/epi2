package epi2._02arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecrementIntegerAsList {
	
	static List<Integer> increment(List<Integer> a) {
		
		// decrement last element
		int n = a.size() - 1;
		a.set(n, a.get(n) - 1);
		
		// decrement next higher digit if a carry was used
		// this will only be needed if smallest digit was 0 and decremented
		for (int i = n; i > 0 && a.get(i) == -1; i--) {
			a.set(i, 9);
			a.set(i - 1, a.get(i - 1) - 1);
		}
		
		// remove leading 0
		if (a.get(0) == 0) {
			a.remove(0);
		}
		
		return a;
	}

	public static void main(String[] args) {
		System.out.println(increment(new ArrayList<>(Arrays.asList(1,0))));//9
		System.out.println(increment(new ArrayList<>(Arrays.asList(1,2,4))));//1,2,3
		System.out.println(increment(new ArrayList<>(Arrays.asList(1,3,0))));//1,2,9
		System.out.println(increment(new ArrayList<>(Arrays.asList(9,0,0))));//8,9,9
		System.out.println(increment(new ArrayList<>(Arrays.asList(1,0,0,0))));//9,9,9
		System.out.println(increment(new ArrayList<>(Arrays.asList(0))));//-1
		System.out.println(increment(new ArrayList<>(Arrays.asList(-9))));//-1,0 // TODO
	}

}
