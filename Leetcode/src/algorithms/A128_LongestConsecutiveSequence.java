package algorithms;

import java.util.HashSet;

public class A128_LongestConsecutiveSequence {
	public static void main(String [] args) {
		A128_LongestConsecutiveSequence a128 = new A128_LongestConsecutiveSequence();
		int[] nums = new int[] {100, 4, 200, 1, 3, 2};
		System.out.println(a128.longestConsecutive(nums));
	}
	
	//accepted solution.
	//very excited cause only try 2 times for this hard level problem without any other references
	public int longestConsecutive(int[] nums) {
		
        HashSet <Integer> set = new HashSet<Integer>();

        int max = 1;
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        HashSet <Integer> set2 = new HashSet<Integer>();

        for(int x : set) {
            if(set2.contains(x)) continue;
            int len = 1;
            while(set.contains(x + 1)) {
                set2.add(x);
                x++;
                len++;
            }
            if(len > max) max = len;
        }
        
        return max;
    }
}
