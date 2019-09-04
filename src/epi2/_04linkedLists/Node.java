package epi2._04linkedLists;

public class Node {
	Integer value;
	Node next;
	
	Node(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}
