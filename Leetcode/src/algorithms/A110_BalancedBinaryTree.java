package algorithms;

import data.TreeNode;

public class A110_BalancedBinaryTree {
	
	boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        
        getDepth(root);
        return balance;
    }
    
    private int getDepth(TreeNode root) {
        if (!balance) return 0;
        if (root == null) return 0;
        
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        
        if(left - right >1 || right - left >1) balance = false;
        return Math.max(left, right) + 1;
        
    }
    
    
    //second solution runtime is approximately equal
    public boolean isBalanced2(TreeNode root) {
        
        // getDepth(root);
        // return balance;
        return maxDepth(root) != -1;
    }
    
    private int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int L = maxDepth(root.left);
        if (L==-1) return -1;
        int R = maxDepth(root.right);
        if(R == -1) return -1;
        return (Math.abs(L-R) <=1 ) ? (Math.max(L, R) + 1) : -1;
    }
}
