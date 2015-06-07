package algorithms;

public class A137_SingleNumberII {
	
    
	
	//my solution passed
	public int singleNumber(int[] nums) {
        
        int[] bits_cache = new int[32];
        
        for(int x : nums) {
            int position = 0;
            while(position < 32) {
                
                int last_bit = x & 1;
                if(last_bit == 1) bits_cache[position] ++;
                x = x >> 1;
                position ++ ;
            }
        }
        int result = 0;
        
        for(int i = 0; i < 32; i++) {
            
            if(bits_cache[i] % 3 == 1) result |= 1 << i; 
        }
        
        return result;
    }
	
	
	//clean code solution 2
	public int singleNumber3Mask(int[] nums) {
        
        int ones = 0, twos = 0, threes = 0;
        
        for(int x : nums) {
            
            twos |= ones & x;
            ones ^= x;
            
            threes = ones & twos;
            
            //if three clear one
            ones &= ~threes;
            //if three clear two
            twos &= ~threes;
        }
        
        return ones;
    }
	
}
