package algorithms;

public class A53_MaximumSubArray {

	/**
	 * f(k) = max(f(k-1) + A (k), A(k))
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
        
        int max_temp = nums[0], max = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            
            max_temp = Math.max(max_temp + nums[i], nums[i]);
            max = Math.max(max_temp, max);
        }
        
        return max;
    }
}
