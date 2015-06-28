package algorithms;

public class A14_LongestCommonPrefix {
	
	public static void main (String[] args) {
		A14_LongestCommonPrefix a14 = new A14_LongestCommonPrefix();
		String[] strs = {"ab", "ab", "abc", "abcd"};
		System.out.println(a14.longestCommonPrefix(strs));
		
	}
	
	//key point is only prefix
	public String longestCommonPrefix(String[] strs) {
        int p = 0;
        if(strs.length == 0) return "";
        String last_common = "";
        while(p < strs[0].length()) {
            String common = strs[0].substring(0, p + 1);
            int i = 1;
            while(i < strs.length) {
                if(p >= strs[i].length() || !strs[i].substring(0, p + 1).equals(common)) return last_common;
                i++;
            }
            
            last_common = common;
            p ++;
        }
        
        return last_common;
    }
}
