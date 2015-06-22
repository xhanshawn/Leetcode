package algorithms;

public class A9_PalindromeNumber {
	
	//my way is to reverse totally and compare based problem A7
	//better way is compare each pair by Integers not String(extra spaces)
	public boolean isPalindrome(int x) {
	       if(x<0) return false;
	    //   else return x == reverse(x); 
	        
	        int div = 1;
	        while(x/div >= 10) {
	            div *= 10;
	        }
	        
	        while(x != 0) {
	            int first = x/div;
	            int last = x%10;
	            if(first != last) return false;
	            x = x%div;
	            x = x/10;
	            div = div/100;
	        }
	        
	        return true;
	    }
	    
	    
	    
	    //language specific way, because of overflow;
	    public int reverse(int x) {
	        boolean neg = (x < 0) ? true : false;
	        int result = 0;
	        int p = 0;
	        while (x!=0 && p< 9) {
	            result = result * 10 + (x%10);
	            x = x/10;
	            p++;
	        }
	        if(result > Integer.MAX_VALUE/10) return 0;
	        if(x == 0) return result;
	        if(x < 8 && !neg) return result*10 + x;
	        if(x < 9 && neg) return result*10 + x;
	        return 0;
	    }
}
