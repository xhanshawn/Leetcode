package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A170_TwoSumIII {
	
	Map<Integer, Integer> map = new HashMap<>();
	//design a data structure may have dupilcates
	public void add(int input){
		
		int count;
		if(map.containsKey(input)) count = map.get(input) + 1;
		else count = 1;
		map.put(input, count);
	}
	
	//need to care about duplicate situation
	public boolean find(int target){
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			
			int diff =  target - entry.getKey();
			if(diff == entry.getKey()) {
				
				if(map.get(diff) > 1) return true;
			} else {
				
				if(map.containsKey(diff)) return true;
			}
		}
		
		return false;
	}
}
