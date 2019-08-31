package epi2._03strings;

import java.util.LinkedList;
import java.util.List;

public class ComputeMnemonicsPhoneNumber {
	
	static String[] map = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	
	static List<String> computeMnemonics(String number) {
		List<String> mnemonics = new LinkedList<>();
		mnemonics.add("");
		
		for (int i = 0; i < number.length(); i++) {
			char[] array = map[number.charAt(i) - '0'].toCharArray();

			int n = mnemonics.size();
			for (int k = 0; k < n; k++) {
				String temp = mnemonics.get(0);
				mnemonics.remove(temp);
				for (int j = 0; j < array.length; j++) {
					mnemonics.add(temp + array[j]);
				}
			}
		}
		
		return mnemonics;
	}

	public static void main(String[] args) {
		System.out.println(computeMnemonics("23"));//ad, ae, af, bd, be, bf, cd, ce, cf
	}

}
