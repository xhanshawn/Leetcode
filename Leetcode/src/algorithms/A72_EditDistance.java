package algorithms;

public class A72_EditDistance {
	public static void main(String[] args) {
		A72_EditDistance a72 = new A72_EditDistance();
		System.out.println("" + a72.minDistance("acd", "abcd"));
		System.out.println("" + a72.minDistance("abcd", "abcd"));
		System.out.println("" + a72.minDistance("abdd", "abcd"));
		System.out.println("" + a72.minDistance("abcdd", "abcd"));
		System.out.println("" + a72.minDistance("a", "b"));
		System.out.println("" + a72.minDistance("sea", "ate"));


	}
	public int minDistance(String word1, String word2) {
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
                    if(next1 == next2) {
                    	i++;
                    	j++;
                    }
                    //delete
                    else if(next1 == cur2) i++;
                    //insert
                    else if(next2 == cur1) j++;
                    else {
                    	i++;
                    	j++;
                    }
                } else {
                	i++;
                	j++;
                }
                num++;
            }else {
            	i++;
            	j++;
            }
        }
		System.out.println("" + num);
		System.out.println("i" + i + " j" + j );

        if(i < word1.length()) num += word1.length() - i;
        else if(j < word2.length()) num += word2.length() - j;
        
        return num;
    }
}
