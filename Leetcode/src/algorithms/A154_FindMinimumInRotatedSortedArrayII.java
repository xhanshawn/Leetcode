package algorithms;

public class A154_FindMinimumInRotatedSortedArrayII {
	
	
	// my accepted solution may be redundant in the lines
	// idea is when A[b] == A[m] || A[e] == A[m];
	// find both sides and return min one.
	public int findMin(int[] nums) {
        
        return nums[find(nums, 0, nums.length-1)];
    }
    
    
    
    private int find(int[] nums, int b, int e) {
        if(b == e) return b;
        
        int m = (b + e)/2;

        if(nums[b] == nums[e]) {
            int left = find(nums, b, m);
            int right = find(nums, m + 1, e);
            
            if(nums[left] < nums[right]) return left;
            else return right;
        }
        
        if(nums[m] > nums[e]) return find(nums, m + 1, e);
        else return find(nums, b, m);
        
    }
    
    
    // clean code solution if repeat happens,
    // call for next point
    // better performance
    public int findMin2(int[] nums) {
        
        return nums[find2(nums, 0, nums.length-1)];
    }
    
    
    
    private int find2(int[] nums, int b, int e) {
        if(b >= e) return b;
        
        int m = (b + e)/2;


        if( m!=e && nums[m] == nums[e]) return find(nums, b, e - 1);
        if( m!=b && nums[m] == nums[b]) return find(nums, b + 1, e);

        if(nums[m] > nums[e]) return find(nums, m + 1, e);
        else return find(nums, b, m);
        
    }
}
