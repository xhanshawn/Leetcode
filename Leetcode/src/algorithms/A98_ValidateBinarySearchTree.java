package algorithms;

import data.TreeNode;

public class A98_ValidateBinarySearchTree {
	
	//key point to record previous tree node
	private TreeNode previous = null;
	
    
    public boolean isValidBST(TreeNode root) {

        return validateByTraverse(root);
        
    }
    
    //In-order traversal way to verify validation
    private boolean validateByTraverse(TreeNode root) {
        if(root == null) return true;
        boolean result = true;
        
        result = validateByTraverse(root.left);

        if(previous != null && root.val <= previous.val) return false;
        
        previous = root;

        result = result && validateByTraverse(root.right);
        
        return result;
    }
}
