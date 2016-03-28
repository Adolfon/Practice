package practice.java.structures;

public class Trees {

	TreeNode root;
	/* 4.1 CCI book
	 * Implement a function to check if a binary tree is balanced. For the purposes of this
		question, a balanced tree is defined to be a tree such that the heights of the two
		subtrees of any node never differ by more than one
	 */
	
// ------------------------ First no optimal approach O(N^2)----------------------	
	//We just recurse the whole tree and for each node, compute the heights of each subtree.
	public static int getHeight(TreeNode root){
		if (root==null) return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)+1);
	}//getHeight
	
	
	public static boolean isBalanced(TreeNode root){
		if (root==null)return true;
		int leftHeight=getHeight(root.left);
		int rightHeight=getHeight(root.right);
		if (Math.abs(leftHeight-rightHeight)<1)
			return false;
		else // Recurse the whole tree (I quite not understand if is unBalanced if the first 
			//two subTrees (level 1) I shouldn't need to ask the same question for the bellow nodes IMHO ..
			return (isBalanced(root.left)&&isBalanced(root.right));		
	}//isBalanced

// ------------------------ Second approach O(N) and space O(H)----------------------	
	//it is accomplish just cutting recursivity when you detect is not balanced with 
	// a function integrated in the same getHeight method.
	
	public static int checkHeight2(TreeNode root){
		if (root==null) return 0;
		
		
		
		int leftHeight=checkHeight2(root.left);
		if (leftHeight==-1)
			return -1; //Not balanced
		
		
		int rightHeight=checkHeight2(root.right);
		if (rightHeight==-1)
			return -1;//Right not balanced
		
		//check actual node
		int heightDiff=leftHeight-rightHeight;
		if (Math.abs(heightDiff)>1)
			return -1;
		else
			return Math.max(leftHeight, rightHeight) +1;
		
	}
	
	public static boolean isBalanced2(TreeNode root){
		if (checkHeight2(root)==-1)
			return false;
		else
			return true;
	}//isBalanced
	
	
	
	
	
	public static void main(String[] args){
		//Make a tree
		Trees tree=new Trees();		
		TreeNode n1= new TreeNode(1);
		TreeNode n2= new TreeNode(2);
		TreeNode n3= new TreeNode(3);
		TreeNode n4= new TreeNode(4);
		TreeNode n5= new TreeNode(5);
		TreeNode n6= new TreeNode(6);
		TreeNode n7= new TreeNode(7);
		TreeNode n8= new TreeNode(8);
		TreeNode n9= new TreeNode(9);
		
		tree.root=n1;
		n1.left=n2;
		n1.right=n3;
		n3.left=n4;
		n3.right=n5;
		System.out.println(tree.checkHeight2(tree.root));// (output 3)
		n4.left=n6;
		System.out.println(tree.checkHeight2(tree.root));// (output -1)
		n2.left=n7;
		System.out.println(tree.checkHeight2(tree.root));// (output 4)
	}
	
	
}//Tree class

 class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int dat){
		this.data=dat;
		left=right=null;
	}
}// Nested class TreeNode
