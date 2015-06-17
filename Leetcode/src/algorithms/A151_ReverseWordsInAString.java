package algorithms;

public class A151_ReverseWordsInAString {
	
	public static void main(String[] args) {
		
		A151_ReverseWordsInAString a151 = new A151_ReverseWordsInAString();
		System.out.println(a151.reverseWords("1"));
		System.out.println(a151.reverseWords("the sky is blue"));
		System.out.println(a151.reverseWords2(" 1"));

	}
	
	
	
	//my first solution, far from concise
	//but fast, 228 ms
	//may be because of using string buffer
	public String reverseWords(String s) {
        String[] strs = s.split(" ");
        
        int i = 0;
        int j = strs.length - 1;
        
        while(i < j) {
            
            String temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
            
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        
        for(int k=0; k<strs.length; k++) {
            if(strs[k].equals("")) continue;
            sb.append(strs[k] + " ");
        }
        String result = sb.toString();
        while(result.length() > 0 && result.endsWith(" ")) {
        	
        	result = result.substring(0, result.length()-1);
        }
        
        return result;
	}
	
	//not passed because of not handling the test case where "" happens in the strs
	//String.join is bad for this situation
	public String reverseWords2(String s) {
        String[] strs = s.split(" ");
        
        int i = 0;
        int j = strs.length - 1;
        
        while(i < j) {
            
            String temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
            
            i++;
            j--;
        }
        
        String result = String.join(" ", strs);
        while(result.length() > 0 && result.endsWith(" ")){
        	result = result.substring(0, result.length() - 1);
        }
        return result;
	}
}
