package algorithms;

import java.util.ArrayList;
import java.util.List;

import data.TreeLinkNode;
import data.TreeNode;

public class A116_PopulatingNextRightPointersinEachNode {
	public static void main(String[] args) {
		TreeLinkNode r1 = new TreeLinkNode(1);
		r1.left = new TreeLinkNode(2);
		r1.right = new TreeLinkNode(3);
		r1.left.left = new TreeLinkNode(4);
		r1.left.right = new TreeLinkNode(5);
		r1.right.left = new TreeLinkNode(6);
		r1.right.right = new TreeLinkNode(7);
		List<Integer> result = new ArrayList<Integer> ();
		A116_PopulatingNextRightPointersinEachNode a116 = new A116_PopulatingNextRightPointersinEachNode();
		a116.connect(r1);
		TreeLinkNode p = r1;
		while(p != null) {
			TreeLinkNode q = p;
			while(q != null) {
				System.out.print(q.val + "->");
				q = q.next;
			}
			System.out.println(" ");
			p = p.left;
		}
	}
	
	
    List<TreeLinkNode> nodes = new ArrayList<TreeLinkNode>();
    //accepted solution O(log(n)) memory. 
    //also based on preorder traversal
    //after I used same solution to try A117 and accepted
    //I thought this problem can use one time traverse and mathematical way to solve
    //which is really constant way. use a counter? 
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
