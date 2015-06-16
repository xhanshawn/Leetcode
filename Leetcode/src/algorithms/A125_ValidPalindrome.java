package algorithms;

public class A125_ValidPalindrome {
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
//		String s = "ab";

		A125_ValidPalindrome a125 = new A125_ValidPalindrome();
		if(a125.isPalindrome2(s)) System.out.println("true");
		else System.out.println("no");
	}
	
	
	//the key point is to remember Character related api
	//so easier to use psduo-code
	public boolean isPalindrome(String s) {
        
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
           
            if(!Character.isLetterOrDigit(s.charAt(i))) {
                i++; 
                continue;
            }
            
            if(!Character.isLetterOrDigit(s.charAt(j))) {
                j--; 
                continue;
            }
            
            if(Character.toLowerCase(s.charAt(i)) != 
            		Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        
        return true;
    }
	
	//write api by myself a bit better performance
	public boolean isPalindrome2(String s) {
        
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
           
            if(!isLetterOrNumber(s.charAt(i))) {
                i++; 
                continue;
            }
            
            if(!isLetterOrNumber(s.charAt(j))) {
                j--; 
                continue;
            }
            
            if(convertToLowerCase(s.charAt(i)) != 
            		convertToLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        
        return true;
    }
	
	private boolean isLetterOrNumber(char ch){
		
		if((ch >= 'a' && ch <= 'z') ||
				(ch >= 'A' && ch <= 'Z') ||
				(ch >= '0' && ch <= '9')) return true;
		else return false;
	}
	
	private char convertToLowerCase(char upper) {
		
		if(upper >= 'A' && upper <= 'Z') {
			
			return (char) ('a' + (upper - 'A')); 
		}
		
		return upper;
	}
	
}
