package epi2._06binaryTress;

public class HeightOfBinaryTree {

	static class Node {
		Node left;
		Node right;
		
		Node(Node left, Node right) {
			this.left = left;
			this.right = right;
		}
	}
	
	static int height(Node root) {
		if (root == null) {
			return -1;
		}
		
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public static void main(String[] args) {
		System.out.println(height(null)); // -1
		System.out.println(height(new Node(null, null))); // 0
		
		// Figure 6.1
		
		Node D = new Node(null, null);
		Node E = new Node(null, null);
		Node H = new Node(null, null);
		Node M = new Node(null, null);
		Node N = new Node(null, null);
		Node P = new Node(null, null);
		
		Node L = new Node(null, M);
		Node G = new Node(H, null);
		Node K = new Node(L, N);
		
		Node C = new Node(D, E);
		Node F = new Node(null, G);
		Node J = new Node(null, K);
		Node O = new Node(null, P);

		Node B = new Node(C, F);
		Node I = new Node(J, O);

		Node A = new Node(B, I);
		
		System.out.println(height(A));
		System.out.println(height(B));
		System.out.println(height(C));
		System.out.println(height(D));
		System.out.println(height(E));
	}

}
