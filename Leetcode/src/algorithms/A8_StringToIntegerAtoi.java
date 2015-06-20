package algorithms;

public class A8_StringToIntegerAtoi {
	
	public static void main (String[] args) {
		
		A8_StringToIntegerAtoi a8 = new A8_StringToIntegerAtoi();
		
		
		System.out.println("" + a8.myAtoi("25"));
		System.out.println("" + a8.myAtoi("-25"));
		System.out.println("" + a8.myAtoi("-0025"));
		System.out.println("" + a8.myAtoi("+25"));
		System.out.println("" + a8.myAtoi("Adwe-b25dddaer"));
		System.out.println("" + a8.myAtoi("" + Integer.MAX_VALUE));
		System.out.println("" + Integer.MAX_VALUE);
		System.out.println("" + a8.myAtoi("" + Integer.MIN_VALUE));
		System.out.println("" + Integer.MIN_VALUE);
		System.out.println("" + a8.myAtoi("-2147483649"));
		System.out.println("" + a8.myAtoi("-ADAERAERD-214748369"));
		System.out.println("" + a8.myAtoi("  -0012a42"));

		
	}
	
	//far from consice answer
	//tried many times on Online Judge
	//No detailed description on the OJ
	public int myAtoi(String str) {
        
        //number
        //0011
        //other charachter
        //+-
        //overflow
        
        int i = 0 ;
        int result = 0;
        boolean neg = false;
        boolean symbol = false;
        boolean has_result = false;
        boolean no_char = true;
        while(result < Integer.MAX_VALUE/10 && i < str.length()) {
        	char current = str.charAt(i);
        	
        	if(current == '+' || current == '-') {
                
                if(symbol) return 0;
                else symbol = true;
                if(str.charAt(i) == '+') neg = false;
                if(str.charAt(i) == '-') neg = true;
            }else if(current <= '9' && current >= '0') {
            		result = result * 10 + current - '0';
            		has_result = true;
            }
            else if(has_result) {
            	no_char = false;
            	break;
            }
            i++;
        }
        
        if(i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
            
            if(!neg) {
            
                if(str.charAt(i) - '0' <= Integer.MAX_VALUE % 10 
                		&& result <= Integer.MAX_VALUE/10) {
                    
                    return result * 10 + (str.charAt(i) - '0'); 
                }else {
                
                    return (no_char) ? Integer.MAX_VALUE : 0;
                }
            } else {
            	
                result = 0 - result;
                
                if(str.charAt(i) - '0' <= 0 - Integer.MIN_VALUE % 10 && result >= Integer.MIN_VALUE/10) {
                    
                    return result * 10 - (str.charAt(i) - '0');
                }else {
                	
                    return (no_char) ? Integer.MIN_VALUE : 0;
                }
            }
            
        } else {
            
            if(neg) return 0 - result;
            else return result;
        }
        
        
    }
	
	
	
	//correct solution much better
	private static final int maxDiv10 = Integer.MAX_VALUE/10;
    public int myAtoi2(String str) {
        
        int i = 0, n = str.length();
        while(i < n && Character.isWhitespace(str.charAt(i))) i++;
        int sign = 1;
        
        if(i<n && str.charAt(i) == '+') {
            i++;
        } else if (i<n && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        
        int num = 0;
        while(i<n && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            if(num > maxDiv10 || num == maxDiv10 && digit >= 8) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;        
        
    }
}
