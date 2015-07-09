package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A72_EditDistance {
	public static void main(String[] args) {
		A72_EditDistance a72 = new A72_EditDistance();
		System.out.println("" + a72.minDistance("acd", "abcd"));
		System.out.println("" + a72.minDistance("abcd", "abcd"));
		System.out.println("" + a72.minDistance("abdd", "abcd"));
		System.out.println("" + a72.minDistance("abcdd", "abcd"));
		System.out.println("" + a72.minDistance("a", "b"));
		System.out.println("" + a72.minDistance("sea", "ate"));
		System.out.println("" + a72.minDistance("horse", "ros"));
		System.out.println("" + a72.minDistance("horse", ""));

	}
	
	public int minDistance(String word1, String word2) {
		
		if(word1.length() == 0 || word2.length() == 0) return Math.abs(word1.length() - word2.length());
		//prefix;
		word1 = " " + word1;
		word2 = " " + word2;
		int[][] distances = new int[word1.length()][word2.length()];
		
		
		//distances[1][1] is the starting point of conversion
		for(int i=0; i < word1.length(); i++) {
			distances[i][0] = i;
		}
		for(int j=0; j < word2.length(); j++) {
			distances[0][j] = j;
		}
		
		
		for(int i=1; i < word1.length(); i++) {
			for(int j=1; j < word2.length(); j++) {
				//append at the end
				distances[i][j] = Math.min(distances[i-1][j], distances[i][j-1]) + 1;
				int last = distances[i-1][j-1];
				if(word1.charAt(i) != word2.charAt(j)) ++last;
				distances[i][j] = Math.min(distances[i][j], last);
			}
		}
		
		return distances[word1.length()-1][word2.length()-1];
	}
	public int minDistance3(String word1, String word2) {
		
		HashMap<Character,ArrayList<Integer>> map = new HashMap<Character,ArrayList<Integer>>();
		
		int i = 0;
		while(i < word2.length()) {
			ArrayList<Integer> positions = map.get(word2.charAt(i));
			if(positions == null) positions = new ArrayList<Integer>();
			positions.add(i);
			map.put(word2.charAt(i), positions);
			i++;
		}
		
		i = 0;
		int cur_pos = -1;
		int com_num = 0;
		int pre1 = 0,pre2 = 0,aft1 = 0,aft2 = 0;
		while(i < word1.length()) {
			ArrayList<Integer> positions = map.get(word1.charAt(i));
			if(positions != null) {
				for(int x : positions) {
					if(x > cur_pos) {
						if(cur_pos == -1) {
							pre1 = i;
							pre2 = x;
						}
						cur_pos = x;
						aft1 = i;
						com_num++;
					}
				}
			}
			i++;
		}
		aft2 = cur_pos;
		i--;
//		if(word1.length() > word2.length()) return word1.length() - com_num;
		
		return Math.max(pre1, pre2) + Math.max(word1.length() - aft1 - 1, word2.length() - aft2 - 1)
				+ Math.max(aft1 - pre1, aft2 - pre2) - com_num + 1;
	}
	public int minDistance2(String word1, String word2) {
		
		int i =0;
        int j = 0;
        int num = 0;
        while(i < word1.length() && j < word2.length()){
            char cur1 = word1.charAt(i);
            char cur2 = word2.charAt(j);
            if(cur1 != cur2) {
                
                if(i + 1 < word1.length() && j + 1 < word2.length()) {
                	
                    char next1 = word1.charAt(i + 1);
                    char next2 = word2.charAt(j + 1);
                    
                    //delete
                    if(next1 == cur2 && next1 != next2) j--;
                    //insert
                    else if(next2 == cur1 && next1 != next2) i--;
                } 
                num++;
            }

            i++;
            j++;
        }
        
        
        if(i < word1.length()) {
        	num += word1.length() - i;
        	
			boolean has_end = false;
        	while(i < word1.length() && word2.length() > 0){
        		if(word1.charAt(i) == word2.charAt(word2.length()-1)) has_end = true;
        		i++;
        	}
        	if(has_end) num--;
        }
        else if(j < word2.length()) num += word2.length() - j;
        
        return num;
		
	}
	
	public int minDistance1(String word1, String word2) {
        int i =0;
        int j = 0;
        int num = 0;
        
        while(i < word1.length() && j < word2.length()){
            char cur1 = word1.charAt(i);
            char cur2 = word2.charAt(j);
            if(cur1 != cur2) {
                
                if(i + 1 < word1.length() && j + 1 < word2.length()) {
                	
                    char next1 = word1.charAt(i + 1);
                    char next2 = word2.charAt(j + 1);
                    
                    //delete
                    if(next1 == cur2) j--;
                    //insert
                    else if(next2 == cur1) i--;
                } 
                num++;
            }

            i++;
            j++;
        }

        if(i < word1.length()) num += word1.length() - i;
        else if(j < word2.length()) num += word2.length() - j;
        
        return num;
    }
}
