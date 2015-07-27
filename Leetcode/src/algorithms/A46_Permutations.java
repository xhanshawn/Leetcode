package algorithms;

import java.util.ArrayList;
import java.util.List;

public class A46_Permutations {
	
	public static void main(String[] args) {
		A46_Permutations a46 = new A46_Permutations();
		List<List<Integer>> result = a46.permute2(new int[] {1, 2, 3});
		System.out.println(result);

	}
	//accepted solution easy problem
	//insert existed lists a new number
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0) return result; 
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        result.add(list);
        for(int i = 1; i < nums.length; i++) {
            while(result.get(0).size() < i + 1) {
            	
                for(int j = 0; j <= result.get(0).size(); j++) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.addAll(result.get(0));
                    temp.add(j, nums[i]);
                    result.add(temp);
                }
                result.remove(0);
            }
        }
        
        return result;
    }
	
	public List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0) return result;
        return getPerm(nums, 0);
	}

	public List<List<Integer>> getPerm(int[] nums, int p) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(p >= nums.length - 1) {
        	List<Integer> list = new ArrayList<Integer>();
        	for(int i : nums) list.add(i);
        	result.add(list);
        	return result;
        }

        for(int i = p; i < nums.length; i++) {
        	int[] temp = nums;
        	int t =  temp[i];
        	temp[i] = temp[p];
        	temp[p] = t;
        	print(temp);
    		System.out.println("  ....   ");
        	print(nums);

        	result.addAll(getPerm(temp, p + 1));
        }
        
        return result;
	}
	private void print(int[] nums) {
		for(int i : nums) System.out.print("  " +  i + "   ");
		System.out.println("  ");
	}
}
