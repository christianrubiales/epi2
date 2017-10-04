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
		
		// if there is a last carry, add it as the first value
		if (carry != 0) {
			c.add(0, carry);
		}
		
		return c;
	}

	// return a - b
	static List<Integer> subtract(List<Integer> a, List<Integer> b) {
		// if a is not smaller than b, negate all values in b
		if (a.size() < b.size()) {
			for (int i = 0; i < b.size(); i++) {
				b.set(i, -b.get(i));
			}
		} else { // b is larger, swap a and b, and negate all values in a
			List<Integer> t = a;
			a = b;
			b = t;
			for (int i = 0; i < a.size(); i++) {
				a.set(i, -a.get(i));
			}
		}
		
		return processSigns(add(a, b));
	}
	
	static List<Integer> processSigns(List<Integer> a) {
		for (int i = 1; i < a.size(); i++) {
			a.set(i, Math.abs(a.get(i)));
		}
		
		return a;
	}

//	static List<Byte> add(List<Byte> a, List<Byte> b) {
//		List<Byte> c = new ArrayList<>(a.size() >= b.size() ? a : b);
//		List<Byte> d = new ArrayList<>(a.size() < b.size() ? a : b);
//		int diff = c.size() - d.size();
//		byte carry = 0;
//		
//		// add the overlapping digits
//		for (int i = d.size() - 1; i > -1; i--) {
//			byte sum = (byte) (c.get(diff + i) + d.get(i) + carry);
//			c.set(diff + i, (byte) (sum % 10));
//			carry = (byte) (sum / 10);
//		}
//
//		// add the carry to the remaining digits of the larger number
//		for (int i = diff - 1; i > -1; i--) {
//			byte sum = (byte) (c.get(i) + carry);
//			c.set(i, (byte) (sum % 10));
//			carry = (byte) (sum / 10);
//		}
//		
//		// if there is a last carry, the list has to grow
//		if (carry != 0) {
//			c.add(0, carry);
//		}
//		
//		return c;
//	}

	public static void main(String[] args) {
		System.out.println(add(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(0))));//1
		System.out.println(add(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(1))));//2
		System.out.println(add(new ArrayList<>(Arrays.asList(9)), new ArrayList<>(Arrays.asList(1))));//1,0
		System.out.println(add(new ArrayList<>(Arrays.asList(5,0)), new ArrayList<>(Arrays.asList(5,0))));//1,0,0
		System.out.println(add(new ArrayList<>(Arrays.asList(9,9)), new ArrayList<>(Arrays.asList(9,9))));//1,9,8

		System.out.println(subtract(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(0))));//1
		System.out.println(subtract(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(1))));//0
		System.out.println(subtract(new ArrayList<>(Arrays.asList(0)), new ArrayList<>(Arrays.asList(1))));//-1
		System.out.println(subtract(new ArrayList<>(Arrays.asList(9)), new ArrayList<>(Arrays.asList(1))));//8
		System.out.println(subtract(new ArrayList<>(Arrays.asList(1,0)), new ArrayList<>(Arrays.asList(2,0))));//-1,0
		System.out.println(subtract(new ArrayList<>(Arrays.asList(1,0)), new ArrayList<>(Arrays.asList(2,2))));//-1,2
		System.out.println(subtract(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(9,9))));//-9,8
		System.out.println(subtract(new ArrayList<>(Arrays.asList(-1)), new ArrayList<>(Arrays.asList(9,9))));//-1,0,0
	}

}
