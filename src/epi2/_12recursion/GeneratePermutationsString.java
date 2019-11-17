package epi2._12recursion;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutationsString {
	
	static List<String> permute(String s) {
		List<String> results = new ArrayList<>();
		
		permute("", s, results);
		
		return results;
	}
	
	static void permute(String prefix, String suffix, List<String> results) {
		if (suffix.isEmpty()) {
			results.add(prefix);
		} else {
			for (int i = 0; i < suffix.length(); i++) {
				permute(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1), results);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(permute("123"));
		System.out.println(permute("1234"));
	}

}
