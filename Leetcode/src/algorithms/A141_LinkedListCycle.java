package algorithms;

import data.ListNode;

public class A141_LinkedListCycle {
	// two pointers solution 
	// p step by step
	// q double step
	public boolean hasCycle(ListNode head) {
        
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode q = head;
        while(q != null && p !=null && p != q) {
            p = p.next;
            q = q.next;
            if(q != null) q = q.next;
        }
        
        return (p == q && q != null);
    }
}
