package algorithms;

import data.ListNode;

public class A19_RemoveNthNodeFromEndofList {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode p = head;
//		for(int i = 2; i < 6; i++) {
//			p.next = new ListNode(i);
//			p = p.next;
//		}
		A19_RemoveNthNodeFromEndofList a14 = new A19_RemoveNthNodeFromEndofList();
		head = a14.removeNthFromEnd(head, 1);
		p = head;
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        
        int num = 0;
        
        //p2 should be n + 1 th before p1  (difference is n + 1)
        //p1 will be null not the end
        while(p1 != null && num < n + 1) {
           p1 = p1.next;
           num++;
        }
        if(p1 == null) {
        	if(num == n) return head.next;
        	if(num < n) return head;
        }
        ListNode p2 = head;
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        ListNode next_node = p2.next.next;
        p2.next = null;
        p2.next = next_node;
        
        return head;
    }
}
