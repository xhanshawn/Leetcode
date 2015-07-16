package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A49_Anagrams {
	public static void main(String[] args) {
		A49_Anagrams a49 = new A49_Anagrams();
		String[] strs = new String[] {"ate","eat"};
		List<String> result = a49.anagrams(strs);
		for(String str : result) {
			System.out.println(str);
		}
	}
	
	//my idea is using character maps and string as flag
	//508 ms solution may be slow
	public List<String> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>> ();
        for(int i = 0; i < strs.length; i++) {
            int j = 0;
            String flag = "";
            int[] chs = new int[26];
            while(j < strs[i].length()) {
                chs[strs[i].charAt(j) - 'a'] ++ ;
                j++;
            }
            for(int c : chs) {
            	flag += "" + c;
            }
            List<String> list;
            if(map.get(flag) == null) {
            	list = new ArrayList<String>();
            	list.add(strs[i]);
            	map.put(flag, list);
            }
            else {
            	list = map.get(flag);
            	list.add(strs[i]);
                map.replace(flag, list);
            }
        }
        List<String> result = new ArrayList<String>();
        for(String i : map.keySet()) {
            if(map.get(i).size() > 1) {
                result.addAll(map.get(i));
            }
        }       
        
        return result;
    }
}
