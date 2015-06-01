package algorithms;

import data.ListNode;

public class A24_SwapNodesIInPairs {
	
	
	
	
	public ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // handle the null input situation
        if(head == null) return head;
        if(head.next != null ) dummy.next = head.next;
        
        ListNode parent = null;
        
        while(head != null && head.next !=null) {
            
            ListNode node_1 = head;
            ListNode node_2 = head.next;
            ListNode node_3 = head.next.next;
            
            if(parent != null){
                parent.next = node_2;
            }
            
            parent = node_1;
            node_1.next = node_3;
            node_2.next = node_1;
            
            head = node_1.next;
        }
        
        return dummy.next;
    }
}
