package algorithms;

import java.util.ArrayList;
import java.util.List;

import data.TreeNode;

public class A105_ConstructBinaryTreefromPreorderandInorderTraversal {
	
	public static void main(String[] args){
		
		A105_ConstructBinaryTreefromPreorderandInorderTraversal a105 = new A105_ConstructBinaryTreefromPreorderandInorderTraversal();
		
//		int [] p = new int[] {1, 2, 4, 5, 3};
////		int [] i = new int[] {4, 2, 5, 1, 3};
//		int [] i = new int[] {3,5,4,2,1};
		
		
		int [] p = new int[] {1, 2};
		int [] i = new int[] {1, 2};

		TreeNode root = a105.buildTree(p, i);
		
		TreeNode.printTreeNode(root);
	}
	
	
	//624ms accepted solution somewhat slow..
	int r;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
    	r = 0;
        List<Integer> list = new ArrayList<Integer>();
        for(int i : inorder) {
            list.add(i);
        }
        return build(preorder, list);
    }
    
    private TreeNode build(int[] preorder, List<Integer> inorder){
        if(inorder.size() == 0) return null;
        if(inorder.size() == 1) {
            r++;
            return new TreeNode(inorder.get(0));
        }
        int i = 0;
        while(i < inorder.size()){
            if(inorder.get(i) == preorder[r]) break;
            i++;
        }
        
        TreeNode root = new TreeNode(preorder[r]);
        r++;
        root.left = build(preorder, inorder.subList(0, i));
        
        if(i + 1 < inorder.size()) root.right = build(preorder, inorder.subList(i + 1, inorder.size()));
        
        return root;
    }
}
