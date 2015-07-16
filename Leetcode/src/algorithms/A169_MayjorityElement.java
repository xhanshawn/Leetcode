package algorithms;

import java.util.HashMap;
import java.util.Map;

public class A169_MayjorityElement {
	
	//accepted solution, easy problem.
	public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer> (); 
        
        for(int i : nums) {
            if(map.get(i) == null) {
                map.put(i, 1);
                if(nums.length/2 < 1) return i;
            }
            else {
                int n = map.get(i);
                if(n + 1 > nums.length/2) return i; 
                map.replace(i, n + 1);
            }
        }
        
        return 0;
    }
}
