package algorithms;

import data.TreeNode;

public class A111_MinimumDepthOfBinaryTree {
	 
	public int minDepth(TreeNode root) {
		
		if(root == null) return 0;
		
		//key point is to ignore one of children is null
		if(root.left == null) return minDepth(root.right) + 1;
		if(root.right == null) return minDepth(root.left) + 1;
		
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}
