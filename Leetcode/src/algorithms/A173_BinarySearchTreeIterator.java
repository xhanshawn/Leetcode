package algorithms;

import java.util.ArrayList;

import data.TreeNode;

public class A173_BinarySearchTreeIterator {
    
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(7);
		t1.left.left = new TreeNode(2);
		t1.left.right = new TreeNode(4);
		t1.right.left = new TreeNode(6);
		BSTIterator ite =  new BSTIterator(t1);
		while(ite.hasNext()) {
			System.out.println(ite.next() + " ");
		}
		
	}
	
	
	static class BSTIterator{
    	ArrayList<Integer> list = new ArrayList<Integer> ();

    	public BSTIterator(TreeNode root) {
            traverseInorder(root);
        }
        
        private void traverseInorder(TreeNode root) {
            if(root == null) return;

            traverseInorder(root.left);
            list.add(root.val);
            traverseInorder(root.right);
        }
        
        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return list.size() > 0;
        }

        /** @return the next smallest number */
        public int next() {
            int result = list.get(0);
            list.remove(0);
            return result;
        }
    }
    
}