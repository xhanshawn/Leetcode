package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import data.TreeNode;

public class A199_BinaryTreeRightSideView {

	public static void main(String[] args) {
		A199_BinaryTreeRightSideView a199 = new A199_BinaryTreeRightSideView();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.left = t2;
		t2.left = t4;
		t1.right = t3;
		List<Integer> result = a199.rightSideView(t1);
		for(int i = 0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}

	}
	
	HashMap<Integer, ArrayList<Integer>> levels = new HashMap<Integer, ArrayList<Integer>>();
//    int max = -1;
    
    //accepted solution 328ms not the best in java
    public List<Integer> rightSideView(TreeNode root) {
    	recordLevel(root, -1);
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i = 0; i < levels.size(); i++) {
            ArrayList<Integer> current = levels.get(i);
            result.add(current.get(current.size() - 1));
        }
        
        return result;
    }
    
    private void recordLevel(TreeNode root, int lv) {
        if(root == null) return;
        ArrayList<Integer> list = levels.get(lv + 1);
        if(list == null) {
        	list = new ArrayList<Integer> ();
            list.add(root.val);
            levels.put(lv + 1, list);
        }else  list.add(root.val);
        
//        if(lv + 1 > max) max = lv + 1;
        
        recordLevel(root.left, lv + 1);
        recordLevel(root.right, lv + 1);
    }
}
