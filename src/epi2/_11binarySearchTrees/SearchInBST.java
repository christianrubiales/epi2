package epi2._11binarySearchTrees;

public class SearchInBST {

	static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	static Node search(Node node, int value) {
		if (node == null || node.value == value) {
			return node;
		}
		
		if (value < node.value) {
			return search(node.left, value);
		} else {
			return search(node.right, value);
		}
	}

}
