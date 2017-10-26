package epi2._04linkedLists;

public class TestCyclicity {
	
	static boolean hasCycle(Node head) {
		Node slow = head;
		Node fast = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {

	}

}
