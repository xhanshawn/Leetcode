package algorithms;

public class A70_ClimbingStairs {
	
	
	//if using recursive way time limits will exceed
	//using DP f(n) = f(n-1) + f(n-2); 
	public int climbStairs(int n) {
        
        int p = 1, q = 1;
        
        for(int i=1; i<n; i++) {
            
            int temp = q;
            q += p;
            p = temp;
        }
        
        return q;
    }
}
