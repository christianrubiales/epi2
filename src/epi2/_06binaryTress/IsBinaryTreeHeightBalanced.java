package epi2._06binaryTress;

// For each node in the tree, the difference in the height of
// its left and right subtrees is at most 1
// @see https://discuss.leetcode.com/topic/7798/the-bottom-up-o-n-solution-would-be-better
public class IsBinaryTreeHeightBalanced {
	
	static class Node {
		Node left = null;
		Node right = null;
	}
	
	// -1 means the heights are unbalanced
	static int getHeightDifference(Node node) {
		if (node == null) {
			return 0;
		}
		
		int left = getHeightDifference(node.left);
		if (left == -1) {
			return -1;
		}
		
		int right = getHeightDifference(node.right);
		if (right == -1) {
			return -1;
		}
		
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		
		return 1 + Math.max(left, right);
	}
	
	static boolean isHeightBalanced(Node root) {
		return getHeightDifference(root) != -1;
	}

	public static void main(String[] args) {
		System.out.println(isHeightBalanced(null)); // true
		System.out.println(isHeightBalanced(new Node())); // true
		
		Node root = new Node();
		root.left = new Node();
		root.left.left = new Node();
		root.left.left.left = new Node();
		root.left.left.left.left = new Node();
		System.out.println(isHeightBalanced(root)); // false
	}

}
