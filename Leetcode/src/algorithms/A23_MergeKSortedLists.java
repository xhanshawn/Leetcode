package algorithms;

import java.util.ArrayList;
import java.util.List;

import data.HeapFactory;
import data.ListNode;

public class A23_MergeKSortedLists {
	
	
	public static void main(String[] args) {
		
		ListNode dummy1 = new ListNode(0);
		ListNode l1 = dummy1;
		
		for(int i=0; i<30; i+=2){
			
			l1.next = new ListNode(i);
			l1 = l1.next;
		}
		
		ListNode dummy2 = new ListNode(0);
		
		ListNode[] lists = new ListNode[2];
		lists[0] = dummy1.next;
		lists[1] = dummy2.next;
		
//		ListNode result = A23_MergeKSortedLists.mergeKSortedListsByHeap(lists);
		ListNode result = A23_MergeKSortedLists.mergeKSortedLists(lists);

		while(result != null){
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
	
	/**
	 *  runtime 400ms about half of the limit 
	 * @param lists
	 * @return
	 */
	public static ListNode mergeKSortedLists(ListNode[] lists) {
		
		int start = 0;
		int end = lists.length -1;
		while(end > 0){
			start = 0;
			
			while(start < end){
				lists[start] = A21_MergeTwoSortedLists.merge2SortedLists(lists[start], lists[end]);
				start++;
				end--;
			}
		}
		
		return lists[0];
	}
	
	public static ListNode mergeKSortedListsByHeap(ListNode[] lists){
		
		if(lists.length == 0) return null;
		
		List<ListNode> list_nodes = new ArrayList<ListNode> ();
		int i = 0;
		while(i<lists.length){
			ListNode p = lists[i];
			while(p != null){
				
				list_nodes.add(p);
				p = p.next;
			}
			
			i++;
		}
		
		HeapFactory.buildListNodeMinHeap(list_nodes);
		
		int size = list_nodes.size();
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		
		for (int j= list_nodes.size() - 1; j> 0; j--) {
			p.next = list_nodes.get(0);
			list_nodes.set(0, list_nodes.get(j));
			p = p.next;
			size--;

			HeapFactory.minHeapifyListNode(list_nodes, 0, size);
		}
		
		return dummy.next;
		
	}
}
