package algorithms;

import data.ListNode;
import data.TreeNode;

public class A109_ConvertSortedListToBST {
	
	private ListNode list;
    
    public TreeNode sortedListToBST(ListNode head) {
        ListNode p = head;
        int length = 0;
        
        //get the list size
        while (p != null) {

        	length++;
            p = p.next;
        }
        
        //reset pointer to start
        list = head;
        
        return buildBST(0, length - 1);
        
    }
    
    /**
     * To traverse from bottom to top, considering the property of ListNode
     * we have to do call for left child first, record it and then get current
     * pointer value, move pointer forward then call for right child.
     * So it is left -> get pointer and push -> right
     * @param b
     * @param e
     * @return
     */
    private TreeNode buildBST(int b, int e) {
        
        if(b > e) return null;
        
        int m = (b + e)/2;
        
        TreeNode root;
        
        TreeNode left = buildBST(b, m - 1);
        
        // only this part get the value and create tree node so move pointer 
        // here, after left and before right.
        root = new TreeNode(list.val);
        root.left = left;
        list = list.next;
        root.right = buildBST(m + 1, e);
        return root;
    }
}
