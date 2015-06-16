package algorithms;

import java.util.HashMap;
import java.util.Map;

public class A167_TwoSumII {
	
	
	
	//O(n) O(1)
	public int[] getTwoSumByTwoPointer(int[] nums, int target) throws Exception {
		
		int i = 0;
		int j = nums.length - 1;
		
		while(i<j) {
			
			if(nums[i] + nums[j] == target) return new int[]{i+1, j+1};
			else if(nums[i] + nums[j] < target) i++;
			else if(nums[i] + nums[j] < target) j--;
		}
		
		throw new Exception("No result");
		
	}
	
	public int[] getTwoSum(int[] nums, int target) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer> ();
		
		for (int i=0; i<nums.length; i++) {
			
			if(nums[i]>target) break;
			
			if(map.get(target - nums[i]) == null) {
				map.put(nums[i], i);
			} else {
				
				return new int[] {map.get(target - nums[i]) + 1, i + 1};
			}
			
		}
		
		return null;
	}
}
