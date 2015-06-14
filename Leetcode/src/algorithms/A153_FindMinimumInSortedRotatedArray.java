package algorithms;

public class A153_FindMinimumInSortedRotatedArray {
	
	
	
	public int findMin(int[] nums) {
        
        return nums[find(nums, 0, nums.length-1)];
    }
    
    
    private int find(int[] nums, int b, int e) {
        if(b == e) return b;
        
        int m = (b + e)/2;

        if(nums[m] > nums[e]) return find(nums, m + 1, e);
        else return find(nums, b, m);
    }
}
