package algorithms;

import data.ListNode;

public class A86_PartitionList {
	public static void main(String[] args) {
		A86_PartitionList a86 = new A86_PartitionList();
		ListNode head = ListNode.buildListFromArray(new int[] {1,4,3,2,5,2});
		
		ListNode result = a86.partition(head, 3);
		
		ListNode.printList(result);
	}
	
	//accepted solution. I think it should be a easy problem
	public ListNode partition(ListNode head, int x) {
        ListNode dummy_l = new ListNode(0);
        ListNode dummy_g = new ListNode(0);
        ListNode l = dummy_l;
        ListNode g = dummy_g;
        while(head != null) {
            if(head.val < x) {
                l.next = new ListNode(head.val);
                l = l.next;
            }else {
                g.next = new ListNode(head.val);
                g = g.next;
            }
            
            head = head.next;
        }
        l.next = dummy_g.next;
        return dummy_l.next;
    }
}
