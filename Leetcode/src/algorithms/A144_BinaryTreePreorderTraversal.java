package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import data.TreeNode;

public class A144_BinaryTreePreorderTraversal {
	
	//recursion
	List<Integer> list = new ArrayList<Integer>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        
        traverse(root);
        return list;
    }
    
    private void traverse(TreeNode root){
        if(root == null) return;
        if(root.left != null) traverse(root.left);
        if(root.right != null) traverse(root.right);
        list.add(root.val);
    }
    
    //iteratively 
	public List<Integer> preorderIteratively(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		
		Stack<TreeNode> s1 = new Stack<TreeNode>();
    	s1.push(root);
    	while(root != null && !s1.isEmpty()) {
    		TreeNode r = s1.pop();
    		result.add(r.val);
    		if(r.right != null) s1.push(r.right);
    		if(r.left != null) s1.push(r.left);
    	}
    	return result;
    }
}
