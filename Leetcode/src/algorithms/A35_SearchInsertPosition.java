package algorithms;

public class A35_SearchInsertPosition {
	
	public static void main(String[] args) {
		
		int[] input = {1, 3};
		int target = 4;
		A35_SearchInsertPosition a35 = new A35_SearchInsertPosition();
		int result = a35.searchInsert(input, target);
		
		System.out.println("" + result);
		
		
	}
	
	//leetcode accepted solution
	public int searchInsert(int[] nums, int target) {
        
        return search(0, nums.length-1, nums, target);
    }
    
    private int search(int b, int e, int[] nums, int target) {
        
        if(b == e) {
            if(target > nums[b]) return b+1;
            else return b;
        }
        
        int m = (b + e)/2;
        
        if(target > nums[m]) return search(m + 1, e, nums, target);
        else return search(b, m, nums, target);
    }
}
