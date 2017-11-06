package epi2._05stacksAndQueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// @see https://discuss.leetcode.com/topic/7647/java-solution-with-a-queue-used
public class BinaryTreeLevelOrderTraversal {

	static class Node {
		int val;
		Node left;
		Node right;
		
		Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	static List<List<Integer>> levelOrderTraversal(Node root) {
		List<List<Integer>> levels = new ArrayList<>();

		if (root != null) {
			Deque<Node> queue = new ArrayDeque<>();
			queue.push(root);
			
			while (!queue.isEmpty()) {
				int size = queue.size();
				List<Integer> level = new ArrayList<>(size);
				levels.add(level);

				for (int i = 0; i < size; i++) {
					if (queue.peek().left != null) {
						queue.push(queue.peek().left);
					}
					if (queue.peek().right != null) {
						queue.push(queue.peek().right);
					}
					level.add(queue.pop().val);
				}
			}
		}
		
		return levels;
	}
	
	public static void main(String[] args) {
		Node D = new Node(28, null, null);
		Node E = new Node(0, null, null);
		Node H = new Node(17, null, null);
		Node M = new Node(641, null, null);
		Node N = new Node(257, null, null);
		Node P = new Node(28, null, null);
		
		Node L = new Node(401, null, M);
		Node G = new Node(3, H, null);
		Node K = new Node(1, L, N);
		
		Node C = new Node(271, D, E);
		Node F = new Node(561, null, G);
		Node J = new Node(2, null, K);
		Node O = new Node(271, null, P);

		Node B = new Node(6, C, F);
		Node I = new Node(6, J, O);

		Node A = new Node(314, B, I);
		
		System.out.println(levelOrderTraversal(A)); // [[314], [6, 6], [271, 561, 2, 271], [28, 0, 3, 1, 28], [17, 401, 257], [641]]
	}

}
