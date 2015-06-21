package algorithms;

import java.util.ArrayList;
import java.util.List;

public class A163_MissingRanges {
	
	public static void main(String[] args) {
		
		A163_MissingRanges a163 = new A163_MissingRanges();
		
		int[] nums = {0, 1, 3, 50, 75};
//		ArrayList<String> result = (ArrayList<String>) a163.a163(nums);
		ArrayList<String> result = (ArrayList<String>) a163.a163Further(nums, -100, 100);
		for(String str : result) {
			System.out.println(str);
		}
	}
	
	
	public List<String> a163(int[] nums){
		
		if(nums.length > 100) return null;
		int p = 1;
		List<String> result = new ArrayList<String> ();
		if(nums.length == 0) {
			result.add("0->99");
			return result;
		}

		if(nums[0] > 1) result.add("0->" + (nums[0] - 1));
		if(nums[0] == 1) result.add("0");
		if(nums[0] == 0) p++;
		while (p < nums.length) {
			int left = nums[p-1] + 1;
			int right = nums[p] - 1;
			
			if(left == right) result.add(left + "");
			else if(left < right) result.add(left + "->" + right);
			p++;
		}
		p--;
		if(nums[p] < 98) result.add((nums[p] + 1) + "->99");
		if(nums[p] == 98) result.add("99");
		
		
		return result;
	}
	
	public List<String> a163Further(int[] nums, int start, int end){
		
		if(nums.length > end - start + 1) return null;
		int p = 1;
		List<String> result = new ArrayList<String> ();
		if(nums.length == 0) {
			result.add(start + "->" + end);
			return result;
		}

		if(nums[0] > start + 1) result.add(start + "->" + (nums[0] - 1));
		if(nums[0] == start + 1) result.add(start + "");
		if(nums[0] == start) p++;
		while (p < nums.length) {
			int left = nums[p-1] + 1;
			int right = nums[p] - 1;
			if(left == right) result.add(left + "");
			else if(left < right) result.add(left + "->" + right);
			p++;
		}
		p--;
		if(nums[p] < end - 1) result.add((nums[p] + 1) + "->" + end);
		if(nums[p] == 98) result.add("" + end);
		
		
		return result;
	}
}
