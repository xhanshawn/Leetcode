package algorithms;

import data.ListNode;

public class A142_LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode q = new ListNode(1);
        q.next = head;
        
        while (p != null && q != null && p != q) {
            p = p.next;
            q = q.next;
            if(q != null) q = q.next;
        }
        
        if(p != q) return null;
        
        q = new ListNode(1);
        q.next = head;
        while(p != q) {
            p = p.next;
            q = q.next;
        }
        
        return q;
    }
}
