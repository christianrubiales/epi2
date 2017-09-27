package epi2._02arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// big integer addition
public class AddArbitraryPrecisionIntegers {

	static List<Integer> add(List<Integer> a, List<Integer> b) {
		List<Integer> c = new ArrayList<>(a.size() >= b.size() ? a : b);
		List<Integer> d = new ArrayList<>(a.size() < b.size() ? a : b);
		int diff = c.size() - d.size();
		int carry = 0;
		
		// add the overlapping digits
		for (int i = d.size() - 1; i > -1; i--) {
			int sum = c.get(diff + i) + d.get(i) + carry;
			c.set(diff + i, sum % 10);
			carry = sum / 10;
		}

		// add the carry to the remaining digits of the larger number
		for (int i = diff - 1; i > -1; i--) {
			int sum = c.get(i) + carry;
			c.set(i, sum % 10);
			carry = sum / 10;
		}
		
		// if there is a last carry, the list has to grow
		if (carry != 0) {
			c.add(0, carry);
		}
		
		return c;
	}

	public static void main(String[] args) {
		System.out.println(add(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(0))));//1
		System.out.println(add(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(1))));//2
		System.out.println(add(new ArrayList<>(Arrays.asList(9)), new ArrayList<>(Arrays.asList(1))));//1,0
		System.out.println(add(new ArrayList<>(Arrays.asList(5,0)), new ArrayList<>(Arrays.asList(5,0))));//1,0,0
		System.out.println(add(new ArrayList<>(Arrays.asList(9,9)), new ArrayList<>(Arrays.asList(9,9))));//1,9,8
	}

}
