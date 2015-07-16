package algorithms;

import java.util.HashMap;
import java.util.Map;

public class A87_ScramblingString {
	
	
	public static void main(String[] args) {
		A87_ScramblingString a87 = new A87_ScramblingString();
		if(a87.isScramble("great", "rgeat")) System.out.println("Ok");
		else System.out.println("fuck");
		
		if(a87.isScramble("abb", "bba")) System.out.println("Ok");
		else System.out.println("fuck");
		if(a87.isScramble("hobobyrqd", "hbyorqdbo")) System.out.println("Ok");
		else System.out.println("fuck");
	}
	
	//accepted solution But it is a really annoying problem!!!
	//the partition possibility has no limit is the point which make me get stuck
	public boolean isScramble(String s1, String s2) {
        if(s1.length() == 0) return true;
        
        return partition(s1, s2);
    }
	private boolean partition(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		if(s1.length() == 1) return s1.equals(s2);
		boolean result = false;
		for(int m = 1; m < s1.length(); m++) {
			String fst = s1.substring(0, m);
			String lst = s1.substring(m);
			if(result) break;
			if(compare(fst, s2.substring(0,m)) && compare(lst, s2.substring(m)))
				result |= partition(fst, s2.substring(0,m)) && partition(lst, s2.substring(m));
			else if(compare(fst, s2.substring(s2.length() - m)) && compare(lst, s2.substring(0, s2.length() - m)))
				result |= partition(fst, s2.substring(s2.length() - m)) && partition(lst, s2.substring(0, s2.length() - m));
		}
		
		return result;
	}
	
	
	private boolean compare(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s1.length(); i++) {
			map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
		}
		for(int i = 0; i < s2.length(); i++) {
			if(map.get(s2.charAt(i)) == null) return false;
			if(map.get(s2.charAt(i)) == 1) map.remove(s2.charAt(i));
			else map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
		}
		
		return map.isEmpty();
	}
	
	
	private boolean partition3(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		if(s1.length() == 1) return s1.equals(s2);
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        
        int m = s1.length()/2;
        for(int i = 0; i < s1.length(); i++) {
        	if(i < m) map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        	else map2.put(s1.charAt(i), map2.getOrDefault(s1.charAt(i), 0) + 1);
        }

        Map<Character, Integer> temp1 = new HashMap<Character, Integer>();
        Map<Character, Integer> temp2 = new HashMap<Character, Integer>();
        temp1.putAll(map1);
        temp2.putAll(map2);
        
        
        
        int i = 0;
        while(i < m) {
    		if(map1.get(s2.charAt(i)) == null || map1.get(s2.charAt(i)) <= 0) break;
        	map1.put(s2.charAt(i),map1.getOrDefault(s2.charAt(i), 0) - 1);
        	i++;
        }
        
        if(i == m) {
        	while(i < s1.length()) {
        		if(map2.get(s2.charAt(i)) == null || map2.get(s2.charAt(i)) <= 0) break;
        		map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i), 0) - 1);
        		i++;
        	}
        }
        if(i == s1.length()) 
        	return partition(s1.substring(0,m), s2.substring(0,m)) &&
        			partition(s1.substring(m), s2.substring(m));
        
        i = s1.length() - 1;
        
        while(s1.length() - 1 - i < m) {
    		if(temp1.get(s2.charAt(i)) == null || temp1.get(s2.charAt(i)) <= 0) break;
    		temp1.put(s2.charAt(i),temp2.getOrDefault(s2.charAt(i), 0) - 1);
    		i--;
        }

        if(s1.length() - 1 - i == m){
        	while(i >= 0) {
        		if(temp2.get(s2.charAt(i)) == null || temp2.get(s2.charAt(i)) <= 0) break;
        		temp2.put(s2.charAt(i),temp2.getOrDefault(s2.charAt(i), 0) - 1);
        		i--;
        	}
        }
//        if(i == -1 && s1.length() == 2) return true;
        return (i == -1) && 
    			partition(s1.substring(0, m), s2.substring(s2.length() - m)) &&
    			partition(s1.substring(m), s2.substring(0, s2.length() - m));
	}
	
	
    private boolean partition2(String s1, String s2, 
    Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if(s1.length() == 0) return true;
        
        for(char c : map1.keySet()) {
            if(map2.get(c) == null || map1.get(c) != map2.get(c)) return false;
        }
        
        Map<Character, Integer> temp1 = new HashMap<Character, Integer>();
        Map<Character, Integer> temp2 = new HashMap<Character, Integer>();
        temp1.putAll(map1);
        temp2.putAll(map2);
        
        int m = s1.length()/2;
        System.out.println(s1 +"     "+  s2);

        for(int i = m; i < s1.length(); i++) {
            temp1.put(s1.charAt(i), temp1.getOrDefault(s1.charAt(i), 0) - 1);
            temp2.put(s2.charAt(i), temp2.getOrDefault(s2.charAt(i), 0) - 1);
        }
        for(int i = 0; i < m; i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) - 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) - 1);
        }
        return true;
//        return partition(s1.substring(0, m), s2.substring(0, m), temp1, temp2) && 
//            partition(s1.substring(m, s1.length()), s2.substring(m, s2.length()), map1, map2);
        
    }
}
