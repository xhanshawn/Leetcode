package algorithms;

import java.util.ArrayList;
import java.util.List;

import data.TreeLinkNode;

public class A117_PopulatingNextRightPointersinEachNodeII {
	List<TreeLinkNode> nodes = new ArrayList<TreeLinkNode>();
    //accepted solution O(log(n)) memory
	//as same as A116
	public void connect(TreeLinkNode root) {
        traverse(root, 0);
    }
    
    private void traverse(TreeLinkNode root, int lv) {
        if(root == null) return;
        if(lv > nodes.size() - 1) nodes.add(root);
        else {
            nodes.get(lv).next = root;
            nodes.add(lv, root);
            nodes.remove(lv + 1);
        }
        
        traverse(root.left, lv + 1);
        traverse(root.right, lv + 1);
    }
}
