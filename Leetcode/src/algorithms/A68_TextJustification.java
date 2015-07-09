package algorithms;

import java.util.ArrayList;
import java.util.List;

public class A68_TextJustification {
	public static void main (String[] args) {
		A68_TextJustification a68 = new A68_TextJustification();
		
//		String [] words = new String [] {"a"};
//		int maxWidth = 1;
//		String [] words = new String [] {"t", "is", "a", "test","a", "case"};
//		int maxWidth = 8;
//		
//		String [] words = new String [] {""};
//		int maxWidth = 10;
//		
//		String [] words = new String [] {"t", "is"};
//		int maxWidth = 10;
		
		String [] words = new String [] {"Listen","to","many","speak","to","a","few."};
		int maxWidth = 6;
		
//		String [] words = new String [] {		"My","momma","always","said,","\"Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."
//};
//		int maxWidth = 20;
		List<String> result = a68.fullJustify(words, maxWidth);
		for(String str : result) {
			System.out.println(str);
		}
	}
	
	
	//accepted solution
	//another problem with many edge cases
	//also solve it without fully understanding the requirements waste my a lot of time.
	public List<String> fullJustify(String[] words, int maxWidth) {
        //for each word in words
        //find as many words as possible which is also less then maxWidth
        //insert white space
        //append to list
        List<String> result = new ArrayList<String> ();
        if(words.length == 0 || maxWidth == 0) {
            result.add("");
            return result;
        }
        int i = 0;
        while(i < words.length) {
            int len = 0;
            int start = i;
            while((i < words.length) && (len + words[i].length() < maxWidth + 1 )) {
                len += words[i].length() + 1;
                //at least one white space
                i++;
            }
            len--;
//			System.out.println(i - start - 1);

            String[] strs = new String[i - start - 1];
            for(int p = 0; p< strs.length; p++) strs[p] = " ";
            while(len < maxWidth && strs.length > 0 && start + strs.length <words.length - 1) {
//    			System.out.println(len);

            	for(int p = 0; p< strs.length; p++) {
            		if(len >= maxWidth) break;
            		strs[p] +=" ";
            		len++;
            	}
            }
            String line = "";
            for(int p = 0; p < strs.length; p++) {
            	line += words[start + p] + strs[p];
            }
            line += words[i - 1];
            while(line.length() < maxWidth) line += " ";
            //last white space
//            int j = 0;
//            while(line.length() < maxWidth) {
//                if(j == line.length() - 1) j = 0;
//                int k = 0;
//                while(j < line.length() && line.charAt(j) != ' ') j++;
//                k = j;
//                while(j < line.length() && line.charAt(j) == ' ') j++;
//                if(j == line.length()) continue;
//                line = line.substring(0,k) + line.substring(k, j)
//                + " " + line.substring(j, line.length());
//                j++;
//            }
            result.add(line);
        }
        
//        String last = "";
//        if(result.size() > 0) last = result.get(result.size() - 1);
//        String tail = last;
//        if(tail.length() > 0 || words[i].length() > 0) {
//        	while(tail.length() > 0 && tail.charAt(tail.length() - 1) == ' ') tail = tail.substring(0,tail.length() - 1);
//            if(maxWidth - tail.length() > words[i].length() + 1) {
//                tail += " " + words[i];
//                result.remove(result.size() - 1);
//            } else {
//                tail = words[i];
//            }
//        }
//        
//        while(tail.length() < maxWidth) tail += " ";
//        result.add(tail);
        return result;
    }
}
