package data;

import java.util.List;

public class HeapFactory {
	
	public static void maxHeapify(int[] A, int i, int size){
		
		int left = i*2 + 1;
		int right = i*2 + 2;
		int largest = i;
		
		if(left < size && A[left] > A[i]) {
			
			largest = left;
		}
		
		if(right < size && A[right] > A[largest]) {
			
			largest = right;
		}
		
		if(largest != i) {
			
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			maxHeapify(A, largest, size);
		}
	}
	
	public static void buildMaxHeap(int[] A) {
		
		int size = A.length;
		for(int i=A.length/2; i>=0; i--){
			
			maxHeapify(A, i, size);
		}
	}
	
	public static void maxHeapSort(int[] A, boolean not_a_heap ) {
		
		if(not_a_heap) {
			
			buildMaxHeap(A);
		}
		
		int size = A.length;
		
		for (int i= A.length - 1; i>0; i--) {
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			
			size--;
			maxHeapify(A, 0, size);
		}
	}
	
	public static void minHeapify(int[] A, int i, int size) {
		
		
		int left = i*2 + 1;
		int right = i*2 + 2;
		int least = i;
		
		if(left < size && A[left] < A[i]) {
			
			least = left;
		}
		
		if(right < size && A[right] < A[least]) {
			
			least = right;
		}
		
		if(least != i) {
			
			int temp = A[i];
			A[i] = A[least];
			A[least] = temp;
			minHeapify(A, least, size);
		}
	}
	
	public static void buildMinHeap(int[] A) {
		
		int size = A.length;
		for(int i=A.length/2; i>=0; i--){
			
			minHeapify(A, i, size);
		}
	}
	
	public static void minHeapSort(int[] A, boolean not_a_heap ) {
		
		if(not_a_heap) {
			
			buildMinHeap(A);
		}
		
		int size = A.length;
		
		for (int i= A.length - 1; i> 0; i--) {
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			
			size--;

			minHeapify(A, 0, size);
		}
	}
	
	
	public static void buildListNodeMinHeap(List<ListNode> list_nodes) {
		int size = list_nodes.size();
		
		for(int i=list_nodes.size()/2; i>=0; i--){
			
			minHeapifyListNode(list_nodes, i, size);
		}
	}
	
	public static void minHeapifyListNode(List<ListNode> list_nodes,int i,int size) {
		
		int left = i*2 + 1;
		int right = i*2 + 2;
		int least = i;
		
		if(left < size && list_nodes.get(left).val < list_nodes.get(i).val) {
			
			least = left;
		}
		
		if(right < size && list_nodes.get(right).val < list_nodes.get(least).val) {
			
			least = right;
		}
		
		if(least != i) {
			
			ListNode temp = list_nodes.get(i);
			list_nodes.set(i,list_nodes.get(least));
			list_nodes.set(least, temp);
			minHeapifyListNode(list_nodes, least, size);
		}
		
	}
	
	 
}
