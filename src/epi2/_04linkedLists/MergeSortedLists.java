package epi2._04linkedLists;

// not modifying the lists is complex
// while modifying the list, iterative is more complex than recursive although easier to comprehend
// @see https://leetcode.com/submissions/detail/22169707/
// @see https://leetcode.com/problems/merge-two-sorted-lists/discuss/215804/Java-Solution-using-two-pointers
// FIXME
public class MergeSortedLists {
	
	static Node merge(Node head1, Node head2) {
		Node head = null;
		Node current = null;
		Node node1 = head1;
		Node node2 = head2;
		
		while (node1 != null && node2 != null) {
			if (node1.value < node2.value) {
				if (head == null) {
					current = node1;
					head = current;
				}
				current.next = node1.next;
				node1 = node1.next;
			} else {
				if (head == null) {
					current = node2;
					head = current;
				}
				current.next = node2.next;
				node2 = node2.next;
			}
		}
		
		while (node1 != null) {
			current.next = node1.next;
			node1 = node1.next;
		}
		
		while (node2 != null) {
			current.next = node2.next;
			node2 = node2.next;
		}
		
		return head;
	}
	
	static void print(Node head) {
		Node node = head;
		
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(2);
		head1.next = new Node(5);
		head1.next.next = new Node(7);

		Node head2 = new Node(3);
		head2.next = new Node(11);
		
		print(merge(head1, head2));
	}

}
