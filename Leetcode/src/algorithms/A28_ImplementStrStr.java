package algorithms;

public class A28_ImplementStrStr {
	
	public static void main(String[] args) {
		A28_ImplementStrStr a28 = new A28_ImplementStrStr();
		System.out.println("" + a28.strStr("aaaaababcddd", "abc"));
		System.out.println("" + a28.strStr("mississippi", "issip"));

	}
	
	//use substring, concise and accept
	//better than the first time in which I used 2 pointers and char
	public int strStr(String haystack, String needle) {
        
        int i=0;
        int n_length = needle.length();
        if(needle.equals("")) return 0;
        
        while(i < haystack.length() - n_length + 1) {
            
        	if(haystack.substring(i, i + n_length).equals(needle)) return i;
        	i++;
        }
        
        return -1;
    }
}
