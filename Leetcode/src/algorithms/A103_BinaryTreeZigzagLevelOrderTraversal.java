package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import data.TreeNode;

public class A103_BinaryTreeZigzagLevelOrderTraversal {
	
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(3);
		n1.left = new TreeNode(9);
		n1.right = new TreeNode(20);
		n1.right.left = new TreeNode(15);
		n1.right.right = new TreeNode(7);
		A103_BinaryTreeZigzagLevelOrderTraversal a103 = new A103_BinaryTreeZigzagLevelOrderTraversal();
		
		List<List<Integer>> result = a103.zigzagLevelOrder(n1);
		for(List<Integer> l : result) {
			for(int i: l) {
				System.out.print(" " + i);
			}
			System.out.println(" ");
		}
		
		TreeNode.printTreeNode(n1);
	}
	
	//BFS solution used on Binary Tree
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		
	    List<List<Integer>> seq = new ArrayList<List<Integer>>();
		Map<TreeNode, Integer> lv_map = new HashMap<TreeNode, Integer>();
		
        if (root == null) return seq;
        lv_map.put(root, 0);
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            int lv = lv_map.get(current);
            List<Integer> list = new ArrayList<Integer>();
            if(lv < seq.size()) {
            	list = seq.get(lv);
            	if(lv % 2 == 0) list.add(current.val);
                else list.add(0, current.val);
            }else {
            	list = new ArrayList<Integer>();
                list.add(current.val);
                seq.add(list);
            }
            if(current.left != null) {
                q.add(current.left);
                lv_map.put(current.left, lv+1);
            }
            if(current.right != null) {
                q.add(current.right);
                lv_map.put(current.right, lv+1);
            }
        }

        return seq;
	}
}
