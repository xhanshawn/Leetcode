package algorithms;

import java.util.Stack;

public class A155_MinStack {
	
	
	Stack<Integer> com_stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    
    public void push(int x) {
        
        com_stack.push(x);
        if(min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
    	
        //cannot use "=="", use .equals instead
    	//peek return element
        if(com_stack.peek().equals(min.peek())) min.pop();
        com_stack.pop();
    }

    public int top() {
        
        return com_stack.peek();
    }

    public int getMin() {
        
        return min.peek();
    }
}
