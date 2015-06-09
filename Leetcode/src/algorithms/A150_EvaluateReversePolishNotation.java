package algorithms;

import java.util.ArrayList;

public class A150_EvaluateReversePolishNotation {
	private ArrayList<Integer> operands = new ArrayList<>();

	
	public static void main (String[] args) {
		A150_EvaluateReversePolishNotation a150 = new A150_EvaluateReversePolishNotation();
		String[] tokens = {
				"0", "3", "/"
		};
		
		System.out.println("" + a150.evalRPN(tokens));
	}
	
	//my accepted solution.
	//unlike the solution of clean code using stack, I used ArrayList
	//I think that way may be very good.
	
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        
        
        for(String str : tokens) {
            
            int size = operands.size();
                
            if(size > 1){
            	
            	// this is only for jre version upper than 1.6
                switch(str) {
                        
                    case "+" : {
                        addResult(operands.get(size - 2) + operands.get(size - 1)); continue;
                    }
                    case "-" : {
                        addResult(operands.get(size - 2) - operands.get(size - 1)); continue;
                    }
                    case "*" : {
                        addResult(operands.get(size - 2) * operands.get(size - 1)); continue;
                    }
                    case "/" : {
                        addResult(operands.get(size - 2) / operands.get(size - 1)); continue;
                    }
                    default: break;        
                }    
                    
                    
            }   
            
            operands.add(Integer.parseInt(str));
        }
        
        return operands.get(0);
    }
    
    private void addResult(int result) {
        
        operands.remove(operands.size() - 1);
        operands.remove(operands.size() - 1);
        operands.add(result);
    }
}
