package algorithms;

import java.util.Arrays;

public class A3_LongestSubstringWithoutRepeatingCharacters {
	
	
	
	
	public static void main(String[] args) {
		
		
		A3_LongestSubstringWithoutRepeatingCharacters a3 = new A3_LongestSubstringWithoutRepeatingCharacters();
		System.out.println("" + a3.lengthOfLongestSubstring("ababcdabc"));
		System.out.println("" + a3.lengthOfLongestSubstring("ee"));
		System.out.println("" + a3.lengthOfLongestSubstring("e"));
		System.out.println("" + a3.lengthOfLongestSubstring("aab"));

	}
	
	public int lengthOfLongestSubstring(String s) {
        int pi=0, pj=0;
        int[] ch_rec = new int[256];
        int max = 0;
        Arrays.fill(ch_rec, -1);
        while(pj < s.length()){
            char current = s.charAt(pj);
            if(ch_rec[current] >= pi) {
            	pi = ch_rec[current] + 1;
                
            }
            ch_rec[current] = pj;
        	max = Math.max(max, pj - pi + 1);

            pj++;
        }
        return max;
    }
}
