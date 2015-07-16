package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A229_MajorityElementII {
	
	
	//accepted solution. In fact, it is as same as the solution of majority elementI
	public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer> (); 
        List<Integer> list = new ArrayList<Integer>();
        for(int i : nums) {
            if(map.get(i) == null) {
                map.put(i, 1);
                if(nums.length/3 < 1) {
                    list.add(i); 
                    map.replace(i, Integer.MIN_VALUE);
                }
            }
            else {
                int n = map.get(i);
                if(n + 1 > nums.length/3) {
                    list.add(i); 
                    map.replace(i, Integer.MIN_VALUE);
                }
                else map.replace(i, n + 1);
            }
        }
        
        return list;    
    }
}
