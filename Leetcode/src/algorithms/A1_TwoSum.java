package algorithms;

import java.util.HashMap;
import java.util.Map;

public class A1_TwoSum {
public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> m_map = new HashMap<Integer, Integer> ();
        
        for(int i=0; i<nums.length; i++) {
            if(m_map.get(target - nums[i]) == null) m_map.put(nums[i], i);
            else {
                int position = m_map.get(target - nums[i]);
                return new int[] {position + 1, i + 1};
            }
        }
        
        return null;        
    }

}
