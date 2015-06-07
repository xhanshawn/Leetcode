package algorithms;

import data.TreeNode;

public class A108_ConvertSortedArrayToBST {
	
	public TreeNode sortedArrayToBST(int[] nums) {
		
        return buildBST(0, nums.length - 1, nums);
    }
    
    private TreeNode buildBST(int b,int e, int[] nums) {
        
        if(b > e) return null;
        
        int m = (e + b)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildBST(b, m - 1, nums);
        root.right = buildBST(m + 1, e, nums);
        
        return root;
    }
}
