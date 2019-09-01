package epi2._03strings;

import java.util.ArrayList;
import java.util.List;

// @see https://leetcode.com/problems/restore-ip-addresses/discuss/30972/WHO-CAN-BEAT-THIS-CODE/29845
public class ComputeValidIPAddresses {
	
	static List<String> computeValidIPAddresses(String address) {
		if (address == null || address.length() < 4 || address.length() > 12) {
			throw new IllegalArgumentException("input must not be null or has length less than 4 or greater than 12");
		}
		
		List<String> valids = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		for (int a = 1; a < 4; a++) {
			for (int b = 1; b < 4; b++) {
				for (int c = 1; c < 4; c++) {
					for (int d = 1; d < 4; d++) {
						if (a+b+c+d == address.length()) {
							String num1 = address.substring(0, a);
							String num2 = address.substring(a, a+b);
							String num3 = address.substring(a+b, a+b+c);
							String num4 = address.substring(a+b+c);
							
							if (isValid(num1) && isValid(num2) && isValid(num3) && isValid(num4)) {
								sb.append(num1).append('.').append(num2).append('.').append(num3).append('.').append(num4);
								valids.add(sb.toString());
								sb.delete(0, sb.length());
							}
						}
					}	
				}	
			}	
		}
		
		return valids;
	}
	
	static boolean isValid(String num) {
		if ((num.charAt(0) == '0' && num.length() > 1) || Integer.parseInt(num) > 255) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(computeValidIPAddresses("19216811"));
		System.out.println(computeValidIPAddresses("192192192192"));//192.192.192.192
		System.out.println(computeValidIPAddresses("0000"));// 0.0.0.0
		System.out.println(computeValidIPAddresses("00000")); //[]
		System.out.println(computeValidIPAddresses("1921921921921"));//IllegalArgumentException
		System.out.println(computeValidIPAddresses("123123123123123"));//IllegalArgumentException
		System.out.println(computeValidIPAddresses("000"));// IllegalArgumentException
		System.out.println(computeValidIPAddresses(null));// IllegalArgumentException
	}

}
