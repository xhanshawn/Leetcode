package algorithms;

import java.util.ArrayList;
import java.util.List;

import data.TreeNode;

public class A94_BinaryTreeInorderTraversal {
	
	
	//ac solution
	List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }
    
    private void traverse(TreeNode root) {
        if(root == null) return;
        if(root.left != null) traverse(root.left);
        
        list.add(root.val);
        
        if(root.right != null) traverse(root.right);
    }
}
