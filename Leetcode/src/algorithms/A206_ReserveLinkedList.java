package algorithms;

import data.ListNode;

public class A206_ReserveLinkedList {
	public static void main (String[] args) {
		ListNode dummy = new ListNode(0);
		dummy.next = new ListNode(1);
//		dummy.next.next = new ListNode(2);
//		dummy.next.next.next = new ListNode(3);
		A206_ReserveLinkedList a206 = new A206_ReserveLinkedList();
		ListNode p = a206.reverseList(dummy.next);
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
	
	
	public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode p = head;
        while(p != null){
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }
        
        return dummy.next;
    }
}
