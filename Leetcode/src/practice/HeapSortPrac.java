package practice;

import data.HeapFactory;

public class HeapSortPrac {
	
	public static void main (String[] args) {
		
		HeapFactory hf = new HeapFactory();
		
		int[] A = new int[50];
		
		for(int i=0; i<50; i++){
			
			A[i] = (int) (Math.random()*100);
			System.out.print(A[i] + " ["+ (i + 1) + "] ");
		}
		System.out.print("\n");
//		hf.buildMaxHeap(A);
//		hf.maxHeapSort(A, true);
//		hf.buildMinHeap(A);
		hf.minHeapSort(A, true);
		
		for(int i=0; i<50; i++){
			
			System.out.print(A[i] + " ["+ (i + 1) + "] ");
		}
	}
}
