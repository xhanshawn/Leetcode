package algorithms;

import java.util.HashSet;
import java.util.Set;

public class A139_WordBreak {
	public static void main(String[] args) {
		A139_WordBreak a139 = new A139_WordBreak();
		Set<String> set = new HashSet<String>();
//		set.add("leet");
//		set.add("code");
		set.add("leet");
		set.add("c");
		set.add("ode");
		if(a139.wordBreak("leetcode", set)) System.out.println("ok");
		else System.out.println("fuck");
	}
	
	public boolean wordBreak(String s, Set<String> wordDict) {
        boolean [][] map = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            if(wordDict.contains(s.charAt(i) + "")) map[i][i] = true;
            else map[i][i] = false;
        }
        int l = 1;
        while(l < s.length()) {
            int i = 0;
            while(i + l< s.length()) {
            	System.out.println("i   " + i + "  j    " + (i+l));
                if( wordDict.contains(s.substring(i, i + l + 1)) ||
                    map[i][i + l - 1] && map[i + l][i + l] ||
                map[i][i + l - 1] && map[i + l][i + l]) map[i][i + l] = true; 
                i++;
            }
            l++;
        }
        
        for(int i = 0; i < s.length() ; i ++) {
        	for(int j = 0; j < s.length(); j ++) {
        		if(map[i][j]) System.out.print("  true ");
        		else System.out.print("  false");
        	}
        	System.out.println("");
        }
        return map[0][s.length() - 1];
    }
}
