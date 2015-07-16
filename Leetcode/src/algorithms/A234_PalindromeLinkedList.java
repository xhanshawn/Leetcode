package algorithms;

import data.ListNode;

public class A234_PalindromeLinkedList {
	
	public static void main (String[] args) {
        ListNode dummy = new ListNode(0);
        dummy.next = new ListNode(-1);
        dummy.next.next = new ListNode(2);
        dummy.next.next.next = new ListNode(2);
        dummy.next.next.next.next = new ListNode(-1);
        A234_PalindromeLinkedList a234 = new A234_PalindromeLinkedList();
        if(a234.isPalindrome(dummy.next)) System.out.println("ok");
        else System.out.println("fuck");
	}
	
	
	//Accepted Solution.
	public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode fst = dummy;
        ListNode sec = dummy;
        ListNode q = dummy;
        int count = 0;
        while(p.next != null) {
            p = p.next;
            count++;
            if(count % 2 == 0) {
            	ListNode temp =  new ListNode(q.next.val);
            	temp.next = fst;
            	fst = temp;
            	q = q.next;
            }
        }
        if(count <= 1) return true;
        sec = (count % 2 == 1) ? q.next.next : q.next;
        while(fst != null && sec != null) {
//        	System.out.println(fst.val + "..." + sec.val);
        	if(fst.val != sec.val) return false;
        	fst = fst.next;
        	sec = sec.next;
        }
        return true;
    }
	
	
	
	
	
	//not accepted solution...TEL...It is O(n) I think 
	public boolean isPalindrome2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode q = dummy;
        StringBuffer fst_sb = new StringBuffer();
        StringBuffer sec_sb = new StringBuffer();
        while(q.next != null) {
            sec_sb.append(q.next.val);
            fst_sb.insert(0, q.next.val);
            q = q.next;
        }
        if(fst_sb.length() <= 1) return true;
        System.out.println(fst_sb.toString() + "..." + sec_sb.toString());
        return sec_sb.toString().equals(fst_sb.toString());
    }
	
}
