package algorithms;

import data.TreeNode;

public class A104_MaximumDepthOfBinaryTree {
	
	//traverse recursively and return max depth of sub trees
	public int maxDepth(TreeNode root) {
		
		if(root == null) return 0;
		
		return Math.max(maxDepth(root.left), maxDepth(root.right));
		
	}
}
