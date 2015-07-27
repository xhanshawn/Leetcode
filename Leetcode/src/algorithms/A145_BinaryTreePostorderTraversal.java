package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import data.TreeNode;

public class A145_BinaryTreePostorderTraversal {
	
	
	
	
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
    
    //////////////////////////
    //both AC 
    
    //two stacks and one list
    public List<Integer> postorderIteratively1(TreeNode root){
    	Stack<TreeNode> s1 = new Stack<TreeNode>();
    	Stack<Integer> s2 = new Stack<Integer>();
    	s1.push(root);
    	while(!s1.isEmpty()) {
    		TreeNode r = s1.pop();
    		if(r.left != null) s1.push(r.left);
    		if(r.right != null) s1.push(r.right);
    		s2.push(r.val);
    	}
    	List<Integer> list = new ArrayList<Integer>();
    	while(!s2.isEmpty()) list.add(s2.pop());
    	return list;
    }
    
    //one stack and one list
    public List<Integer> postorderIteratively2(TreeNode root){
    	Stack<TreeNode> s1 = new Stack<TreeNode>();
    	List<Integer> list = new ArrayList<Integer>();
    	s1.push(root);
    	while(root != null && !s1.isEmpty()) {
    		TreeNode r = s1.pop();
    		if(r.left != null) s1.push(r.left);
    		if(r.right != null) s1.push(r.right);
    		list.add(0, r.val);
    	}
    	return list;
    }
}
