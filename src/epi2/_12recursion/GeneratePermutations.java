package epi2._12recursion;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutations {
	
	static List<List<Object>> permute(List<Object> items) {
		List<List<Object>> result = new ArrayList<>();
		
		permute(new ArrayList<>(), items, result);
		
		return result;
	}
	
	static void permute(List<Object> prefix, List<Object> suffix, List<List<Object>> result) {
		if (suffix.isEmpty()) {
			result.add(prefix);
		} else {
			for (int i = 0; i < suffix.size(); i++) {
				List<Object> suffixCopy = new ArrayList<>(suffix);
				Object object = suffixCopy.remove(i);
				List<Object> prefixCopy = new ArrayList<>(prefix);
				prefixCopy.add(object);
				permute(prefixCopy, suffixCopy, result);
			}
		}
	}

	public static void main(String[] args) {
		List<Object> items = new ArrayList<>();
		items.add("1");
		items.add("2");
		items.add("3");
		items.add("4");
		
		List<List<Object>> result = permute(items);
		
		for (List<Object> list : result) {
			System.out.println(list);
		}
	}

}
