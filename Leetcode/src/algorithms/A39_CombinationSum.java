package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class A39_CombinationSum {
	
	public static void main (String[] args) {
		
		A39_CombinationSum a39 = new A39_CombinationSum();
//		int[] c = new int[] {2,3,6,7};
//		int target = 7;
//		int[] c = new int[] {2,3,5};
//		int target = 8;
//		int[] c = new int[] {8,7,4,3};
//		int target = 11;
		int[] c = new int[] {2,3,8,4};
		int target = 6;
        List<List<Integer>> result = a39.combinationSum(c, target);
        for( List<Integer> l : result) {
        	for(int x : l){
        		System.out.print(x + " ");
        	}
    		System.out.println("");
        }
	}
	
	//accepted solution dfs
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		HashSet <Integer> cs = new HashSet <Integer> ();
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        
        for(int i=0; i < candidates.length; i++) {
            //all non negative
            if(candidates[i] <= target) cs.add(candidates[i]);
        }
        for(int i=0; i < candidates.length; i++) {
            //all non negative
            if(candidates[i] > target) continue;
            List<Integer> list =  new ArrayList<Integer> ();

            list.add(candidates[i]);
            result.addAll(find2(list, cs, target - candidates[i]));
        }
       
		return result;
	}
	
	
	private List<List<Integer>> find2(List<Integer> list, HashSet <Integer> cs, int t) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if(t == 0) {
        	result.add(list);
        	return result;
        }
        for(int x : cs) {

        	int i = list.get(list.size() - 1);

        	if(x >= i && t - x >=0) {

        		List<Integer> temp = new ArrayList<Integer> ();
        		temp.addAll(list);
        		temp.add(x);
        		result.addAll(find2(temp, cs, t - x));
        	}
        }
        
        return result;
    }
	
	
	public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        HashSet <Integer> cs = new HashSet <Integer> ();
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        
        for(int i=0; i < candidates.length; i++) {
            //all non negative
            if(candidates[i] > target) break;
            cs.add(candidates[i]);
            result.addAll(find(candidates[i], cs, target));
        }
        
        
        return result;
    }
    
	private List<List<Integer>> find(int i, HashSet <Integer> cs, int t) {
        if(i > t) return null;
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
//		System.out.println(i + " " + t);

//        if(i == t) {
//            List <Integer> list = new ArrayList<Integer> ();
//            list.add(i);
//            result.add(list);
//            return result;
//        }
        
        for(int x : cs) {
        	if(x == t - i) {
                List <Integer> list = new ArrayList<Integer> ();
                list.add(Math.min(t - i, i));
                list.add(Math.max(t - i, i));
                result.add(list);
            }else {
            	List<List<Integer>> temp = new ArrayList<List<Integer>> ();
                if(x <= t - i) temp = find(x, cs, t - i);
                if(x > i) {
                	for(List<Integer> l : temp) l.add(0, i);
                } else {
                	for(List<Integer> l : temp) l.add(i);
                }
//                for(List<Integer> l : temp) {
//                    for(int p = 0; p<l.size();p++) {
//                    	if(l.get(p) >= i) {
//                    		l.add(p,i); 
//                    		break;
//                    	} else if(p == l.size() - 1) {
//                    	    l.add(p + 1,i); 
//                    		break;
//                    	}
//                    }
//                }
                result.addAll(temp);
            }
        }
        
        
        return result;
    }
}
