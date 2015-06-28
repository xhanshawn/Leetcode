package algorithms;

public class A4_MedianofTwoSortedArrays {
	
	public static void main (String[] args) {
		A4_MedianofTwoSortedArrays a4 = new A4_MedianofTwoSortedArrays();
//		int[] nums1 = {0,1,3};
		
		
//		int[] nums1 = {0,1};
//		int[] nums2 = {2,4};
//		int[] nums1 = {0,1,4,7,8,10};
//		int[] nums2 = {3,5,6,9,11,14};
//		int[] nums1 = {1 };
//		int[] nums2 = {2, 3};
//		int[] nums1 = {1,1};
//		int[] nums2 = {1,1};
		int[] nums1 = {2};
		int[] nums2 = {1};
//		int[] nums1 = {};
//		int[] nums2 = {1};
//		int[] nums1 = {1, 4, 6};
//		int[] nums2 = {1, 5, 9, 10};
//		int[] nums1 = {1};
//		int[] nums2 = {2, 3, 4, 5};
//		int[] nums1 = {1, 2, 7};
//		int[] nums2 = {2, 3, 4, 5, 6};
//		int[] nums1 = {3,3};
//		int[] nums2 = {1, 2};
//		int[] nums1 = {2};
//		int[] nums2 = {1, 3};
		System.out.println("" + a4.findMedianSortedArrays4(nums1, nums2));
 
	}
	
	//accepted solution
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int length1 = nums1.length;
		int length2 = nums2.length;
		
		//assume nums1 longer than nums2
		if(length1 < length2) return findMedianSortedArrays(nums2, nums1);
		
		//if shorter one is 0
		if(length2 == 0) return ((double) (nums1[(length1-1)/2] + nums1[length1/2]))/2.0;
		
		//lower half & higher half of  nums2
		int low = 0, high = length2 * 2;
		
		while(low <= high) {
			
			int cut2 = (low + high)/2;
			int cut1 = length1 + length2 - cut2;
			
			double l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[(cut1 - 1)/2];
			double l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[(cut2 - 1)/2];
			double r1 = (cut1 == length1*2) ? Integer.MAX_VALUE : nums1[cut1/2];
			double r2 = (cut2 == length2*2) ? Integer.MAX_VALUE : nums2[cut2/2];
		    System.out.println(l2 + "" + r1);
		    
		    //log(m + n) performance
			if(l1 > r2) low = cut2 + 1;
			else if (l2 > r1) high = cut2 -1;
			else return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;

		}
		
		return -1;
	}
	//my understanding is sorted problem could use binary way to iterate
	
	
	//my modified accepted solution
	public double findMedianSortedArrays4(int[] nums1, int[] nums2) {
		
		int length1 = nums1.length;
		int length2 = nums2.length;
		
		//assume nums1 longer than nums2
		if(length1 < length2) return findMedianSortedArrays4(nums2, nums1);
		
		//if shorter one is 0
		if(length2 == 0) return ((double) (nums1[(length1-1)/2] + nums1[length1/2]))/2.0;
		
		//the cut idea is really good
		//my understanding is iterating from the end of shorter array
		//then move the two cuts
		//invariant is cut1 + cut2 == length1 + length2
		int cut2 = length2;
		int cut1 = length1 + length2 - cut2;
		
		while(cut2 >= 0 && cut2 <= length2 * 2) {
			cut1 = length1 + length2 - cut2;
			double l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[(cut1 - 1)/2];
			double l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[(cut2 - 1)/2];
			double r1 = (cut1 == length1*2) ? Integer.MAX_VALUE : nums1[cut1/2];
			double r2 = (cut2 == length2*2) ? Integer.MAX_VALUE : nums2[cut2/2];
			if(l1 > r2) cut2 = (length2 + cut2)/2;
			else if (l2 > r1) cut2 = (0 + cut2)/2;
			else return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;

		}
		
		return -1;
	}

	
	public void maxHeapify(int[] A, int i, int size){
		
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
	
	public void buildMaxHeap(int[] A) {
		
		int size = A.length;
		for(int i=A.length/2; i>=0; i--){
			
			maxHeapify(A, i, size);
		}
	}
	
	public void minHeapify(int[] A, int i, int size) {
		
		
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
	
	public void buildMinHeap(int[] A) {
		
		int size = A.length;
		for(int i=A.length/2; i>=0; i--){
			
			minHeapify(A, i, size);
		}
	}
	
	public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
		
		if(nums1.length > nums2.length) return findMedianSortedArrays3(nums2, nums1);
		int length = nums1.length + nums2.length;
        boolean odd = (length%2 == 1);
        int p1 = 0, p2 = 0;
        
        
        
        //case: one empty array
        if(nums1.length == 0 || nums2[nums2.length-1] < nums1[0] && nums1.length!= nums2.length) return (odd) ? nums2[length/2] : (double) (nums2[length/2] + nums2[length/2-1])/2.0;
        
        //case: first element of longer array larger than shorter array
        //p1 -> nums1.length - 1
        if(nums2[0] >= nums1[nums1.length - 1]) p1 = nums1.length-1;
        
        while(p1 + p2 + 2 < length/2 && p1<nums1.length-1 && p2<nums2.length){
            p2 = bSearch(nums2, nums1[p1], p2, nums2.length - 1);
            if(p1 + p2 + 2 < length/2) p1 = bSearch(nums1, nums2[p2 + 1], p1, nums1.length - 1);
        }
        if(p1 > 0) p1--;
    	p2 = length/2 - p1 - 2;
    	
    	System.out.println(p1+" " + p2 );

        if(odd) {
        	
        	return (double) Math.max(nums2[p2 + 1], nums1[p1]);
        }
        else {
        	
        	double before = (p2 < 0) ? nums1[p1]:  (double) Math.max(nums2[p2], nums1[p1]);
        	double after = (p1 == nums1.length-1) ? (double) nums2[p2 + 1] : 
        		(double) Math.min(nums2[p2 + 1], nums1[p1 + 1]);
        	return (after+before)/2.0;
        }
            
	}


	private int bSearch(int[] nums,int target ,int b,int e){
        if(b==e) return b;
    	int m = (b+e)/2;
        if(nums[m] == target) return m;
        if(nums[m] > target) return bSearch(nums, target, b, m);
        else return bSearch(nums, target, m + 1, e);
    }
	
	
	
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int length = nums1.length + nums2.length;
        boolean odd = (length%2 == 1);
        int p1 = 0, p2 = 0;
        
        while(p1 + p2 + 2< length/2){
            p2 = bSearch(nums2, nums1[p1], p2, nums2.length - 1);
            if(p2 + 1 < nums2.length) p1 = bSearch(nums1, nums2[p2 + 1], p1, nums1.length - 1);
        }

        while(p1 + p2 + 2 > length/2){
    		
        	if((nums1[p1] > nums2[p2] || p2 == 0) && p1>0) p1--;
        	else if((nums2[p2] > nums1[p1] || p1 == 0) && p2>0) p2--;
        }
        

        if(odd) {
        	
        	p1 = (p1<nums1.length - 1) ? p1+1 : p1;
        	p2 = (p2<nums2.length - 1) ? p2+1 : p2;
        	return (double) Math.min(nums1[p1], nums2[p2]);
        }
        else {
        	
        	double before = ((double) Math.max(nums1[p1], nums2[p2]));
        	p1 = (p1<nums1.length - 1) ? p1+1 : p1;
        	p2 = (p2<nums2.length - 1) ? p2+1 : p2;
        	double after = ((double) Math.min(nums1[p1], nums2[p2]));
        	System.out.println(before+" " + after );
        	return (after+before)/2.0;
        }
            
    }
    
}
