package epi2._04linkedLists;

public class BootCamp {
	
	static Node search(Node head, int value) {
		Node node = head;
		while (node != null) {
			if (node.value == value) {
				return node;
			}
			node = node.next;
		}
		
		return node;
	}
	
	static void insertAfter(Node node, Node newNode) {
		newNode.next = node.next;
		node.next = newNode;
	}
	
	static void deleteNextNode(Node node) {// can't delete tail node
		node.next = node.next.next;
	}
	
	static void deleteTailNode(Node head) {// can't delete head
		Node node = head;
		Node prev = head;
		
		node = node.next;
		while (node.next != null) {
			prev = prev.next;
			node = node.next;
		}
		
		prev.next = null;
	}
	
	static Node deleteHeadNode(Node head) {
		if (head == null) {
			return null;
		}
		
		Node node = head.next;
		head.next = null;
		
		return node;
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
		Node node = new Node(1);
		Node node2 = new Node(2);
		node.next = node2;
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		Node node5 = new Node(5);
		node.next.next.next.next = node5;
		
		System.out.println(search(node, 3));
		print(node);
		
		Node node6 = new Node(6);
		insertAfter(node5, node6);
		print(node);
		
		Node node7 = new Node(7);
		insertAfter(node, node7);
		print(node);
		
		Node node8 = new Node(8);
		insertAfter(node2, node8);
		print(node);
		
		deleteNextNode(node2);
		print(node);
		
		deleteNextNode(node);
		print(node);
		
		deleteNextNode(node5);
		print(node);
		
		deleteTailNode(node);
		print(node);
		
		Node head = deleteHeadNode(node);
		print(head);
		
		head = deleteHeadNode(head);
		print(head);
		
		head = deleteHeadNode(head);
		print(head);
		
		head = deleteHeadNode(head);
		print(head);
	}

}
