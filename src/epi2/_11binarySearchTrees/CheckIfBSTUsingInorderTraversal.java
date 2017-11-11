package epi2._11binarySearchTrees;

import java.util.ArrayList;
import java.util.List;

// @see https://stackoverflow.com/a/759851
// O(2n) time, O(n) space
// TODO: use iterative inorder to check validity while traversing for just a single pass
// and non-full O(n) space all the time
public class CheckIfBSTUsingInorderTraversal {

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
	
	static void inorder(Node root, List<Integer> traversal) {
		if (root != null) {
			inorder(root.left, traversal);
			traversal.add(root.value);
			inorder(root.right, traversal);
		}
	}
	
	static boolean isBST(Node root) {
		List<Integer> traversal = new ArrayList<>();
		inorder(root, traversal);
		
		for (int i = 0; i < traversal.size() - 1; i++) {
			if (traversal.get(i) > traversal.get(i+1)) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		Node tree = new Node(2, new Node(1), new Node(3));
		List<Integer> traversal = new ArrayList<>();
		inorder(tree, traversal);
		System.out.println(traversal);
		System.out.println(isBST(tree));//true

		tree = new Node(2, new Node(1, new Node(2), null), new Node(3));
		traversal.clear();
		inorder(tree, traversal);
		System.out.println(traversal);
		System.out.println(isBST(tree));//false
	}

}
