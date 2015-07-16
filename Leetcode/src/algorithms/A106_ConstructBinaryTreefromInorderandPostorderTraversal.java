package algorithms;

import java.util.ArrayList;
import java.util.List;

import data.TreeNode;

public class A106_ConstructBinaryTreefromInorderandPostorderTraversal {
	public static void main(String[] args){
		
		
//		int [] p = new int[] {4, 5, 2, 3, 1};
//		int [] i = new int[] {4, 2, 5, 1, 3};
//		int [] i = new int[] {3,5,4,2,1};
		
		
		int [] p = new int[] {1, 2};
		int [] i = new int[] {1, 2};
		A106_ConstructBinaryTreefromInorderandPostorderTraversal a106 = new A106_ConstructBinaryTreefromInorderandPostorderTraversal();
		TreeNode root = a106.buildTree(i, p);
		
		TreeNode.printTreeNode(root);
	}
	
	
	//360ms accepted solution ..don't know why is faster than A105 so much...
	//in fact they are same solution
	int r;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
    	r = postorder.length - 1;
        List<Integer> list = new ArrayList<Integer>();
        for(int i : inorder) {
            list.add(i);
        }
        return build(postorder, list);
    }
    
    private TreeNode build(int[] postorder, List<Integer> inorder){
        if(inorder.size() == 0) return null;
        if(inorder.size() == 1) {
            r--;
            return new TreeNode(inorder.get(0));
        }
        int i = inorder.size() - 1;
        while(i >= 0 ){
            if(inorder.get(i) == postorder[r]) break;
            i--;
        }
        
        TreeNode root = new TreeNode(postorder[r]);
        r--;
        if(i + 1 < inorder.size()) root.right = build(postorder, inorder.subList(i + 1, inorder.size()));
        root.left = build(postorder, inorder.subList(0, i));
        
       
        
        return root;
    }
}
