package practice.algoritm;


// From website:
// http://algorithms.tutorialhorizon.com/tree-traversals/  
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree_Traversal {

	public void levelOrderQueue(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			Node n = (Node) q.remove();
			System.out.print(" " + n.data);
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
	}
	public void DFS(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.add(root);
		while (s.isEmpty() == false) {
			Node x = s.pop();
			if(x.right!=null) s.add(x.right);
			if(x.left!=null) s.add(x.left);			
			System.out.print(" " + x.data);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);

		Tree_Traversal i = new Tree_Traversal();
		System.out.println("Breadth First Search (BFS): ");
		i.levelOrderQueue(root);
		System.out.println();
		System.out.println("Depth First Search (DFS): ");
		i.DFS(root);
	}
}
/*
 * 					  5
 *					/   \
 *				  10     15
 *				 / \	 / \
 *				20	25  30  35
 *			  		 
 *			 
 *
 *Approach:

	Take a Empty Queue.
	Start from the root, 
	insert the root into the Queue.
	Now while Queue is not empty,
	Extract the node from the Queue and insert all its chil­dren into the Queue.
	Print the extracted node.
	
*/
 

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
