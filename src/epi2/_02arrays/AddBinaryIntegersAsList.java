package epi2._02arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddBinaryIntegersAsList {
	
	static List<Integer> add(List<Integer> a, List<Integer> b) {
		List<Integer> c = new ArrayList<>(a.size() >= b.size() ? a : b);
		List<Integer> d = new ArrayList<>(a.size() < b.size() ? a : b);
		int carry = 0;
		
		// add up to the digit of the smaller number
		for (int i = 0; i < d.size(); i++) {
			int sum = c.get(c.size() - 1 - i) + d.get(d.size() - 1 - i) + carry;
			
			if (sum < 2) {
				c.set(c.size() - i - 1, sum);
				carry = 0;
			} else if (sum == 2) {
				c.set(c.size() - i - 1, 0);
				carry = 1;
			} else if (sum == 3) {
				c.set(c.size() - i - 1, 1);
				carry = 1;
			}
		}

		// add the carry to the remaining digits of the larger number
		for (int i = d.size(); i < c.size(); i++) {
			int sum = c.get(c.size() - 1 - i) + carry;
			
			if (sum < 2) {
				c.set(c.size() - i - 1, sum);
				carry = 0;
			} else if (sum == 2) {
				c.set(c.size() - i - 1, 0);
				carry = 1;
			} else if (sum == 3) {
				c.set(c.size() - i - 1, 1);
				carry = 1;
			}
		}
		
		// if there is a last carry, the list has to expand
		if (carry == 1) {
			c.add(0, 1);
		}
		
		return c;
	}
	
	static List<Integer> add2(List<Integer> a, List<Integer> b) {
		List<Integer> c = new ArrayList<>(a.size() >= b.size() ? a : b);
		List<Integer> d = new ArrayList<>(a.size() < b.size() ? a : b);
		int diff = c.size() - d.size();
		int carry = 0;
		
		// add up to the digit of the smaller number
		for (int i = d.size() - 1; i > -1; i--) {
			int sum = c.get(diff + i) + d.get(i) + carry;
			c.set(diff + i, sum % 2);
			carry = sum / 2;
		}

		// add the carry to the remaining digits of the larger number
		for (int i = diff - 1; i > -1; i--) {
			int sum = c.get(i) + carry;
			c.set(i, sum % 2);
			carry = sum / 2;
		}
		
		// if there is a last carry, the list has to expand
		if (carry == 1) {
			c.add(0, 1);
		}
		
		return c;
	}

	public static void main(String[] args) {
		System.out.println(add(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(0))));//1
		System.out.println(add(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(1))));//1,0
		System.out.println(add(new ArrayList<>(Arrays.asList(1,1)), new ArrayList<>(Arrays.asList(1))));//1,0,0
		System.out.println(add(new ArrayList<>(Arrays.asList(1,0,1,1)), new ArrayList<>(Arrays.asList(1))));//1,1,0,0
		System.out.println(add(new ArrayList<>(Arrays.asList(1,0,0,0,0,1,1)), new ArrayList<>(Arrays.asList(1))));//1,0,0,0,1,0,0
	
		System.out.println(add2(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(0))));//1
		System.out.println(add2(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(1))));//1,0
		System.out.println(add2(new ArrayList<>(Arrays.asList(1,1)), new ArrayList<>(Arrays.asList(1))));//1,0,0
		System.out.println(add2(new ArrayList<>(Arrays.asList(1,0,1,1)), new ArrayList<>(Arrays.asList(1))));//1,1,0,0
		System.out.println(add2(new ArrayList<>(Arrays.asList(1,0,0,0,0,1,1)), new ArrayList<>(Arrays.asList(1))));//1,0,0,0,1,0,0
		}

}
