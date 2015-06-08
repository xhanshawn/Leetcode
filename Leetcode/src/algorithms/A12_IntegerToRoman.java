package algorithms;

public class A12_IntegerToRoman {
	
	
	
	
	final private static int[] DECIMAL_MAP = {
        1000, 500, 100, 50, 10, 5, 1
    };
    
    final private static String[] LITERAL_MAP = {
        "M", "D", "C", "L", "X", "V", "I"
    };
    
    //convert by digit, my solution
    public String intToRoman(int num) {
        
        String roman = "";
        
        for(int i = 0; i<LITERAL_MAP.length; i = i+2 ) {

            int digit = num/DECIMAL_MAP[i];
            
            if(DECIMAL_MAP[i]==1) digit = num%10;
            else num %= DECIMAL_MAP[i];
            if(digit == 9) {
                roman +=  LITERAL_MAP[i] + LITERAL_MAP[i-2]; continue;
            }
            
            if(digit == 4) {
                roman +=  LITERAL_MAP[i] + LITERAL_MAP[i-1]; continue;
            }
            
            if(digit<=3) {
                
                for(int j = 0; j<digit; j++ ) {
            
                    roman +=  LITERAL_MAP[i];
                }
                
                continue;
            } 
            
            if(digit<= 8 && digit >= 5) {
                
                roman += LITERAL_MAP[i-1];
                
                for(int j = 0; j<digit-5; j++ ) {
            
                    roman +=  LITERAL_MAP[i];
                }
                
                continue;
            } 
                
        }
        
        return roman;
        
        
    }
}
