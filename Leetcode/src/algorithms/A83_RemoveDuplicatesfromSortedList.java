package algorithms;

import java.util.HashSet;
import java.util.Set;

import data.ListNode;

public class A83_RemoveDuplicatesfromSortedList {
	
	//Accepted solution not good cause doesn't use sorted property
	public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<Integer>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = head;
        while(q != null) {
            while(q != null && set.contains(q.val)) q = q.next;
            if(q != null) set.add(q.val);
            p.next = q;
            p = q;
            if(q != null) q = q.next;
        }
        
        return dummy.next;
    }
}
