package epi2._04linkedLists;

// @see https://leetcode.com/problems/merge-two-sorted-lists/discuss/9715/Java-1-ms-4-lines-codes-using-recursion
public class MergeSortedListsRecursive {

	static Node merge(Node head1, Node head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		
		if (head1.value < head2.value) {
			head1.next = merge(head1.next, head2);
			return head1;
		} else {
			head2.next = merge(head1, head2.next);
			return head2;
		}
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
