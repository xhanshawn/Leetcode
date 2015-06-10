package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class A20_ValidParentheses {
	
	
	//my accepted solution. similar as the clean code one
	//but it is more concise than my solution
	public boolean isValid(String s) {
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put('(', ')');
        parentheses.put('{', '}');
        parentheses.put('[', ']');

        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++) {
            
            char current = s.charAt(i);
            
            
            if(parentheses.get(current) == null) {
                
                if(stack.isEmpty() || 
                !parentheses.get(stack.pop()).equals(current)) return false;
            } else {
                
                stack.push(current); 
            }
            
        }
        
        if(!stack.isEmpty()) return false;
       
        return true;
    }
	
	
}
