package algorithms;

import data.TreeNode;

public class A129_SumRootToLeafNumbers {
	
	public static void main(String[] args) {
		A129_SumRootToLeafNumbers a129 = new A129_SumRootToLeafNumbers();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		
		System.out.println(a129.sumNumbers(t1));
	}
	
	int total = 0;
	//accepted solution
    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return total;
    }
    
    private void traverse(TreeNode root, int sum) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            total += sum*10 + root.val;
        }
        
        traverse(root.left, sum * 10 + root.val);
        traverse(root.right, sum * 10 + root.val);
    }
}
