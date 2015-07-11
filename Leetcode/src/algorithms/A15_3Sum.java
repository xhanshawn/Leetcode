package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class A15_3Sum {
	public static void main (String [] args) {
		int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
		A15_3Sum a15 = new A15_3Sum();
//		int[] nums = new int[] {0,0,0};
//		A15_3Sum a15 = new A15_3Sum();
        List<List<Integer>> result = a15.threeSum(nums);
        for( List<Integer> l : result) {
        	for(int x : l){
        		System.out.print(x + " ");
        	}
    		System.out.println("");
        }
		
	}
	public List<List<Integer>> threeSum(int[] nums) {
		
        HashMap <Integer, Integer> ns = new HashMap <Integer, Integer> ();
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        
        for(int i=0; i < nums.length; i++) {
            if(ns.get(nums[i]) == null) {
            	ns.put(nums[i], 1);
            }else {
            	ns.replace(nums[i], ns.get(nums[i]) + 1);
            }
        }
        for(int e : ns.keySet()) {
            //all non negative
            if(e > 0) continue;
            for(int j : ns.keySet()) {
                if(j >= e && e + j <= 0 && (0 - e - j ) > j && ns.keySet().contains(0 - e -j)) {
                    if(ns.get(e) + ns.get(j) + ns.get(0 - e - j) > 3 || (e != j && j != 0 - e - j)) {

                    	ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(e);
                        list.add(j);
                        list.add(0 - e - j);
                        result.add(list);

                    }
                }
            }
        }

        return result;
    }
}
