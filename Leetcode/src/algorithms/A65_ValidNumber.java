package algorithms;

public class A65_ValidNumber {
	
	public static void main(String[] args) {
		A65_ValidNumber a65 = new A65_ValidNumber();
		if(a65.isNumber("0.  e1")) System.out.println("true");
		else System.out.println("fuck");
		
		
	}
	
	
	//This kind of question is really difficult.
	//many test cases
	//also not easy to write code concisely
	public boolean isNumber(String s) {
        int pos = 0;
        boolean base = false;
        boolean e = false;
        boolean r = false;
        while( pos<s.length() && s.charAt(pos)==' ' ) pos++;
        
        if(pos<s.length() && 
        (s.charAt(pos) == '+' || s.charAt(pos) == '-')) pos++;

        while(pos<s.length() && s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
            base = true;
            pos++;
        }
        
        if(pos<s.length() && s.charAt(pos) == '.') pos++;
        
        while(pos<s.length() && s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
            base = true;
            pos++;
        }
        if(base && pos<s.length() && s.charAt(pos) == 'e') {
        	e = true;
            pos++;
            if(pos<s.length() && 
        (s.charAt(pos) == '+' || s.charAt(pos) == '-')) pos++;
            while(pos<s.length() && 
            s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
                r = true;
                pos++;
            }
        }

        while(pos<s.length() && s.charAt(pos)==' ') pos++;
        
        
        return (e)?  (pos == s.length() && r) : (pos == s.length() && base);
        
//        return (s.charAt(pos-1) == ' ' || (s.charAt(pos-1) >= '0' && s.charAt(pos-1) <= '9'));
    }
}
