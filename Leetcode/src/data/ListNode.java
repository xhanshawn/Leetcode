package data;

public class ListNode {
	public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    
    public static ListNode buildListFromArray(int [] A) {
    	ListNode dummy = new ListNode(0);
    	ListNode p = dummy;
    	
    	for(int i : A) {
    		p.next = new ListNode(i);
    		p = p.next;
    	}
    	
    	return dummy.next;
    }
    
    public static void printList(ListNode head) {
    	while(head != null) {
    		System.out.println("" + head.val);
    		head = head.next;
    	}
    }
}
