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
	
	static int getLengthOfCycle(Node head) {
		Node fast = head;
		Node slow = head;
		int len = 0;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) {
				do {
					len++;
					fast = fast.next;
				} while (fast != slow);
			}
		}
		
		return len;
	}
	
	// understand the mathematical proof of how this works
	// @see http://doctrina.org/Starting_Node_Of_A_Cycle_In_A_Linked_List.html
	// @see https://stackoverflow.com/a/36214925/2256169
	// @see https://stackoverflow.com/a/32190575/2256169
	static Node getStartOfCycle(Node head) {
		Node fast = head;
		Node slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if (slow == fast) {
				slow = head;
				
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				
				return slow;
			}
		}
		
		return null;
	}

	public static void main(String[] args) {

	}

}
