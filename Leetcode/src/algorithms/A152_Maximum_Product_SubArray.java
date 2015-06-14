package algorithms;

public class A152_Maximum_Product_SubArray {
	
	
	//leetcode accepted solution
	// similar with the approach of clean code solution
	//use if to reduce calls of Math.max and Math.min
	public int maxProduct(int[] nums) {
        
        int max_prdt = nums[0], min_prdt = nums[0], result = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            int max = max_prdt;
            int min = min_prdt;
            
            if(nums[i] < 0) {
                max_prdt = Math.max(min * nums[i], nums[i]);
                min_prdt = Math.min(max * nums[i], nums[i]);
            }else {
                
                max_prdt = Math.max(max * nums[i], nums[i]);
                min_prdt = Math.min(min * nums[i], nums[i]);
            }
            
            result = Math.max(max_prdt, result);
        }
        
        return result;
    }
}
