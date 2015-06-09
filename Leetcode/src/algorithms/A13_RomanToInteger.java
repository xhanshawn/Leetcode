package algorithms;

import java.util.HashMap;
import java.util.Map;

public class A13_RomanToInteger {

	final public static int[] DECIMAL_MAP = {
        1000, 500, 100, 50, 10, 5, 1
    };   
    
	
	//my solution, 
    public int romanToInt(String s) {
        
        int[] digit = new int[7];
        
        for(int i=0; i<s.length(); i++) {
            char next = 'I';
            if(i+1 < s.length()) next = s.charAt(i+1);
            char current = s.charAt(i);
            if(current == 'M') digit[0] ++;
            if(current == 'D') digit[1] ++;
            
            if(current == 'C') {
                
                if(next == 'M' || next == 'D') digit[2] --;
                else digit[2] ++;
            }
            
            if(current == 'L') digit[3] ++;
            if(current == 'X') {
                
                if(next == 'C' || next == 'L') digit[4] --;
                else digit[4] ++; 
            }
            
            if(current == 'V') digit[5] ++;
            if(current == 'I') {
                
                if(next == 'X' || next == 'V') digit[6] --;
                else digit[6] ++; 
            }
            
            
        }
        
        int result = 0;
        for(int i=0; i<7; i++) {
            
            result += DECIMAL_MAP[i] * digit[i];
        }
        
        return result;
    }
    
    
    /////////////////////////clean code solution
    private Map<Character, Integer> map = 
    		new  HashMap<Character, Integer>() {{
    			put('I', 1); put('V', 5); put('X', 10);
    			put('L', 50); put('C', 100); put('D', 500);
    			put('M', 1000);
    		}};
    public int romanToIntCleanCode(String s) {
    	
    	int prev = 0, total = 0;
    	for(char c : s.toCharArray()) {
    		int curr = map.get(c);
    		total += (curr > prev) ? (curr - 2 * prev) : curr;
    		prev = curr;
    	}
    	
    	return total;
    }
}
