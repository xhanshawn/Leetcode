package algorithms;

import data.TreeNode;

public class A156_BinaryTreeUpsideDown {
	
	public static void main (String[] args) {
		
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(7);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(10);
		root.left.left.left = new TreeNode(3);
		
		
		A156_BinaryTreeUpsideDown a156 = new A156_BinaryTreeUpsideDown();
		
		root = a156.upsideDownBinaryTree(root);
		while (root != null) {
			System.out.println(root.val + " left: " + ((root.left == null) ? "null" : root.left.val));
			
			System.out.println(root.val + " right: " + ((root.right == null) ? "null" : root.right.val) );
			root = root.left;
		}
		
	}
	
	
	//a confusing problem
	
	public TreeNode upsideDownBinaryTree(TreeNode root){
		
		
		//my solution
//		return upsideDown(root);
		
		//cleancode book solution
		return dfsBottomUp(root, null);
	}
	
	
	private TreeNode upsideDown(TreeNode root) {
		
		if(root == null) return null;
		
		TreeNode left = upsideDown(root.left);
		if(root.right != null) {
			
			root.left = root.right;
			root.left.left = left;
			root.right = null;
		}
		
		
		return root;
	}
	
	private TreeNode dfsBottomUp(TreeNode p, TreeNode parent) {
		
		if(p == null) return parent;
		
		TreeNode root = dfsBottomUp(p.left, p);
		p.left = (parent == null) ? parent : parent.right;
		p.right = parent;
		
		return root;
	}
}
