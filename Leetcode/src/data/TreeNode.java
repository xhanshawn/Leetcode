package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	
	
	public static void printTreeNode(TreeNode root) {
		List<List<Integer>> seq = new ArrayList<List<Integer>>();
		Map<TreeNode, Integer> lv_map = new HashMap<TreeNode, Integer>();
		
        lv_map.put(root, 0);
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            
            int lv = lv_map.get(current);
            List<Integer> list = new ArrayList<Integer>();
            if(lv < seq.size()) {
            	list = seq.get(lv);
            	list.add(current.val);
            }else {
            	list = new ArrayList<Integer>();
                list.add(current.val);
                seq.add(list);
            }
            if(current.left == null && current.right == null) continue;
            if(current.left == null) current.left = new TreeNode(-1);
            if(current.right == null) current.right = new TreeNode(-1);
            q.add(current.left);
            lv_map.put(current.left, lv+1);
            q.add(current.right);
            lv_map.put(current.right, lv+1);
        }
        
        String prefix = " ";
        for(int i = 0; i < seq.size(); i ++) {
        	prefix += " ";
        }
        for(int i = 0; i < seq.size(); i++) {
        	System.out.print(prefix);
        	for(int v : seq.get(i)) {
        		if(v > -1) System.out.print(prefix + v);
        		else System.out.print(prefix + " ");
        	}
        	
        	prefix = prefix.substring(0,  prefix.length() - 1);
        	System.out.println("");
        }
        
	}
	
	
	public static void preorder(TreeNode root, List<Integer> list) {
		list.add(root.val);
		if(root.left != null) preorder(root.left, list);
		if(root.right != null) preorder(root.right, list);
	}
	
}
