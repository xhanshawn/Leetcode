package algorithms;

import java.util.HashSet;
import java.util.Set;

public class A139_WordBreak {
	public static void main(String[] args) {
		A139_WordBreak a139 = new A139_WordBreak();
		Set<String> set = new HashSet<String>();
//		set.add("leet");
//		set.add("code");
//		set.add("leet");
//		set.add("c");
//		set.add("ode");
		set.add("aaaa");
		set.add("aaa");

		if(a139.wordBreak("leetcode", set)) System.out.println("ok");
		if(a139.wordBreak("aaaaaaa", set)) System.out.println("ok");

		else System.out.println("fuck");
	}
	
	//Accepted solution which I didn't figure it out by myself
	public boolean wordBreak(String s, Set<String> wordDict) {
        if(wordDict.contains(s)) return true;
        boolean[] map = new boolean[s.length()];
        String str = s;
        int i = 0;
        while(i < s.length()) {
            int j = i + 1;
            while(j < s.length() + 1) {
            	
            	//i.......j-1, 
            	//...........,i..........j
            	//............i.........j-1
            	
            	//if first line true and second line true then from old i to new j - 1 is true
            	//iterate each position
                if(wordDict.contains(str.substring(i, j))) {
                	if(i == 0 || map[i - 1]) map[j - 1] = true;
                }
                j ++ ;
            }
            i++;
        }
        for(boolean b : map) {
        	if(b) System.out.print("    true");
        	else System.out.print("    false");

        }
        
        System.out.println("");
        return map[s.length() - 1];
    }
	
//	public boolean wordBreak(String s, Set<String> wordDict) {
//        boolean [][] map = new boolean[s.length()][s.length()];
//        for(int i = 0; i < s.length(); i++){
//            if(wordDict.contains(s.charAt(i) + "")) map[i][i] = true;
//            else map[i][i] = false;
//        }
//        int l = 1;
//        while(l < s.length()) {
//            int i = 0;
//            while(i + l< s.length()) {
//            	System.out.println("i   " + i + "  j    " + (i+l));
//                if( wordDict.contains(s.substring(i, i + l + 1)) ||
//                    map[i][i + l - 1] && map[i + l][i + l] ||
//                map[i][i + l - 1] && map[i + l][i + l]) map[i][i + l] = true; 
//                i++;
//            }
//            l++;
//        }
//        
//        for(int i = 0; i < s.length() ; i ++) {
//        	for(int j = 0; j < s.length(); j ++) {
//        		if(map[i][j]) System.out.print("  true ");
//        		else System.out.print("  false");
//        	}
//        	System.out.println("");
//        }
//        return map[0][s.length() - 1];
//    }
}
