package epi2._14greedyAlgorithmsAndInvariants;

public class FindMajorityElement {
	
	static String getMajorityElement(String[] elements) {
		if (elements == null || elements.length == 0) {
			return null;
		}
		
		String current = elements[0];
		int count = 1;
		
		for (int i = 1; i < elements.length; i++) {
			if (elements[i].equals(current)) {
				count++;
			} else {
				count--;
				if (count == 0) {
					current = elements[i];
					count = 1;
				}
			}
		}
		
		return current;
	}

	public static void main(String[] args) {
		System.out.println(getMajorityElement(new String[] {"b","a","c","a","a","b","a","a","c","a"}));//a
		System.out.println(getMajorityElement(new String[] {"b","a"}));//a
	}

}
