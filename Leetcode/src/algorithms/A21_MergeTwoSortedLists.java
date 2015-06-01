package algorithms;

import data.ListNode;

public class A21_MergeTwoSortedLists {
	
	
	public static void main (String[] args){
		
		
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		
		ListNode l1 = dummy1;
		ListNode l2 = dummy2;
		
		for(int i=0; i<30; i+=2){
			
			l1.next = new ListNode(i);
			l1 = l1.next;
		}
		
		for(int i=10; i<25; i++){
			
			l2.next = new ListNode(i);
			l2 = l2.next;
		}
		l1 = dummy1.next;
		while(l1 != null){
			System.out.print(l1.val + " ");
			l1 = l1.next;
		}
		l2 = dummy2.next;
		System.out.println(" ");

		while(l2 != null){
			System.out.print(l2.val + " ");
			l2 = l2.next;
		}
		System.out.println(" ");

		ListNode result = A21_MergeTwoSortedLists.merge2SortedLists(dummy1.next, dummy2.next);

		while(result != null){
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
	
	public static ListNode merge2SortedLists(ListNode l1, ListNode l2){
		
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		
		while(l1 != null && l2 != null) {
			
			if(l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			}else {
				p.next = l2;
				l2 = l2.next;
			}
			
			p = p.next;
		}
		
		if(l1 != null) p.next = l1;
		if(l2 != null) p.next = l2;
		
		return dummy.next;
	}
}
