package algorithms;

public class A5_LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		A5_LongestPalindromicSubstring a5 = new A5_LongestPalindromicSubstring();
		
		System.out.println(a5.longestPalindrome("abcb"));
		System.out.println(a5.longestPalindrome("abcbbbbbadfaadrerwerewfds"));
		System.out.println(a5.longestPalindrome("babcbab"));

	}
	
	public String longestPalindrome(String s) {
        int max = 1;
        String max_str = null;
        
        for(int i=1; i<s.length() - 1; i++){
            String result;
            if((result = findPalindrome(i-1 ,i ,s )).length()> max) {
                max = result.length();
                max_str = result;
            };
            if((result = findPalindrome(i ,i+1 ,s )).length()> max) {
                max = result.length();
                max_str = result;
            };
            if((result = findPalindrome(i-1 ,i+1 ,s )).length()> max) {
                max = result.length();
                max_str = result;
            };
        }
        
        
        
        return max_str;
    }
    
    
    private String findPalindrome(int pi,int pj,String s) {
        while(pi>-1 && pj < s.length() && s.charAt(pi) == s.charAt(pj)) {
        	pi--; pj++;
        }
        return s.substring(++pi, pj);
    }
}
