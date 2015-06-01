package algorithms;

import java.util.HashMap;

import data.RandomListNode;

public class A138_CopyListWithRandomPointer {
	
	public static RandomListNode solveByHashTable(RandomListNode head){
		 
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode p = head;
		RandomListNode q = dummy;
		HashMap <RandomListNode, RandomListNode> map = new HashMap<>();
		
		while(p != null) {
		 	
			q.next = new RandomListNode(p.label);
			//copy corresponding pair of nodes 
			map.put(p, q.next);
			p = p.next;
			q = q.next;
		}
		
		q = dummy.next;
		
		while(q != null) {
			
			if(head.random != null) q.random = map.get(head.random);
			q = q.next;
			head = head.next;
		}
		
		return dummy.next; 
	}
}
