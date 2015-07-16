package algorithms;

import java.util.ArrayList;
import java.util.List;

public class A78_Subsets {
	
	public static void main(String[] args) {
		A78_Subsets a78 = new A78_Subsets();
		
		int[] nums = new int[] {4, 1, 0, 7 , 3, 2, 5, 9, 10,22, 6};
		
		List<Integer> b =  new ArrayList<Integer> ();
		b.add(0);
		for(int i = 0; i< nums.length; i ++) {
            a78.binaryInsert(nums[i], b, 0, b.size() - 1);
        }
		
//		for(int i : b) System.out.println(i + " ");
        List<List<Integer>> result = a78.subsets(nums);
        for(List<Integer> l : result) {
        	for(int i : l) System.out.print(" " + i);
        	System.out.println(" ");
        }
		
		
	}
	
	//accepted solution, sort before finding subset
	//using binary insert to create list
	public List<List<Integer>> subsets(int[] nums) {
		
        if(nums.length == 0) return new ArrayList<List<Integer>>();

        List<Integer> all = new ArrayList<Integer>();
        int dummy = 0;
        all.add(dummy);
        for(int i : nums) {
            binaryInsert(i, all, 0, all.size() - 1);
        }
        
        all.remove(all.size() - 1);
        return subset(all);
    }
    
    private void binaryInsert(int p, List<Integer> all,int  b, int e) {
        if(b == e) {
        	all.add(b, p);
        	return;
        } 
        int m = (b + e)/2;
        if(all.get(m) == p) all.add(p, m);
        if(all.get(m) > p) binaryInsert(p, all, b, m);
        else binaryInsert(p, all, m + 1, e);
    }
    private List<List<Integer>> subset(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.size() == 1) {
            result.add(new ArrayList<Integer> ());
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums.get(0));
            result.add(list);
            return result;
        }
        
        List<List<Integer>> sub = subset(nums.subList(0, nums.size() - 1));
        result.addAll(sub);
        for(List<Integer> l : sub) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(l);
            temp.add(nums.get(nums.size() - 1));
            result.add(temp);
        }
        return result;        
    }
}
