package algorithms;

import data.ListNode;

public class A92_ReverseLinkedListII {
	public static void main(String[] args){
		A92_ReverseLinkedListII a92 = new A92_ReverseLinkedListII();
        ListNode dummy = new ListNode(0);
        dummy.next = new ListNode(1);
        dummy.next.next = new ListNode(2);
        dummy.next.next.next = new ListNode(3);
        dummy.next.next.next.next = new ListNode(4);
        dummy.next.next.next.next.next = new ListNode(5);
        ListNode p = a92.reverseBetween(dummy.next, 3, 4);
        ListNode.printList(p);
	}
	
	//accepted solution care cycle and pointer
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        int i = 1;
        while(p != null && i < m) {
            p = p.next;
            i++;
        }
        ListNode start = p;
        p = p.next;
        ListNode r = p;
        ListNode end = p;
        
        while(p != null && i < n + 1) {
            ListNode next = p.next;
            p.next = r;
            r = p;
            p = next;
            i++;
        }
        start.next = r;
        if(end != null) end.next = p;
        
        return dummy.next;
    }
	
//	public ListNode reverseBetween(ListNode head, int m, int n) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode p = head;
//        int i = 1;
//        while(p != null && i < m - 1) {
//            p = p.next;
//            i++;
//        }
//        ListNode r = p;
//        p = p.next;
////        ListNode r = p;
//        ListNode end = p;
//        i++;
//        while(p != null && i < n + 1) {
//        	ListNode old = r.next;
//        	r.next = p;
//        	p = p.next;
//        	r = r.next;
//        	r.next = old;
//            i++;
//        }
//        if(end != null) end.next = p;
//        
//        return dummy.next;
//    }
}
