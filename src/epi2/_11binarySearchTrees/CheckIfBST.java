package epi2._11binarySearchTrees;

// @see http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
// O(n) time, O(n) space
public class CheckIfBST {

	static class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
		}
		
		Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	static boolean isBST(Node node) {
		return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	static boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.value < min || node.value > max) {
			return false;
		}
		
		return isBST(node.left, min, node.value-1) && 
				isBST(node.right, node.value+1, max);
	}

	public static void main(String[] args) {
		Node tree = new Node(2, new Node(1), new Node(3));
		System.out.println(isBST(tree));//true

		tree = new Node(2, new Node(1, new Node(2), null), new Node(3));
		System.out.println(isBST(tree));//false

	}

}
