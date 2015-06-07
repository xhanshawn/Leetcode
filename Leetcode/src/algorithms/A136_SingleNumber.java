package algorithms;

public class A136_SingleNumber {
	
	
	//also can use hash set, add and remove
	//but use extra space
    public int singleNumber(int[] nums) {
        
        int num = 0;
        for(int x : nums) {
            num ^= x;
        }
        
        return num; 
    }
}
