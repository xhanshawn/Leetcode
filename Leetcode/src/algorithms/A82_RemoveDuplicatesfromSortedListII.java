package algorithms;

import data.ListNode;

public class A82_RemoveDuplicatesfromSortedListII {
	
	public static void main(String[] args) {
		A82_RemoveDuplicatesfromSortedListII a82 = new A82_RemoveDuplicatesfromSortedListII();
		ListNode l1= new ListNode(1);
		l1.next = new ListNode(1);
		l1.next.next = new ListNode(1);
		l1.next.next.next = new ListNode(2);
		l1.next.next.next.next = new ListNode(3);
		l1.next.next.next.next.next = new ListNode(3);

		ListNode dummy = new ListNode(0);
		dummy.next = a82.deleteDuplicates(l1);
		while(dummy.next != null) {
			System.out.println(dummy.next.val);
			dummy = dummy.next;
		}
		
		
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode p = dummy;
        ListNode q = head;
        while(q != null){
            int val = q.val;
            int count = 0;
            while(q.next != null && q.next.val == val) {
            	q = q.next;
            	count++;
            }

            if(count == 0 && q != null) {
            	p.next = q; 
            	q = q.next;
            	p = p.next;
            	//key point. remove next
            	p.next = null;
            }else q = q.next;
        }
        return dummy.next;
    }
}
