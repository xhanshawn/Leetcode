package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class A22_GenerateParenthesis {
	
	public static void main (String[] args) {
		A22_GenerateParenthesis a22 = new A22_GenerateParenthesis();
        List<String> result = a22.generateParenthesis(4);
        for(String str : result) {
//        	System.out.println(str);
        }
        String[] r2 = new String[] {"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())"
        		,"()(())()","()()(())","()()()()"};
        a22.verify(result,r2);
	}
	
	private void verify(List<String> r1, String[] r2) {
		HashSet<String> set = new HashSet<String> ();

		for(String str : r1) {
			if(set.contains(str)) System.out.println(str  + "     this");

			set.add(str);
		}
		for(String str : r2) {
			System.out.println(str);
			if(set.contains(str)) {
				set.remove(str);
			} else {
				System.out.println(str  + "     fuck");
			}
		}
		for(String str : set) {
			System.out.println(str  + "     this");
		}
	}
	
	//accepted solution
	//key point is to find a way to append a new pair of parenthesis for the former recursion result.
	public List<String> generateParenthesis(int n) {
		
		List<String> result = new ArrayList<String>();
        if(n == 0) return result;
        if(n == 1) {
            result.add("()");
            return result;
        }
        
        List<String> list = new ArrayList<String> ();
        list.addAll(generateParenthesis(n - 1));
        for(int i = 0; i < list.size(); i++) {
        	int l = 0;
        	int r = 0;
        	int p = 0;
            result.add("(" + ")" + list.get(i) );
            String str = list.get(i);
        	while(p < str.length()) {
        		if(str.charAt(p) == '(') l ++;
        		else if(str.charAt(p) == ')') r ++;
        		p++;
        		if(l == r) result.add("(" + str.substring(0,p) + ")" + str.substring(p, str.length()));
        	}
        }
        return result;
	}
	public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<String>();
        if(n == 0) return result;
        if(n == 1) {
            result.add("()");
            return result;
        }
        
        List<String> list = new ArrayList<String> ();
        list.addAll(generateParenthesis(n - 1));
        for(int i = 0; i < list.size(); i++) {
            result.add("(" + list.get(i) + ")");
            result.add("(" + ")" + list.get(i) );
            result.add(list.get(i) +"(" + ")");
        }
        result.remove(result.size() - 1);
//        int last = list.size() - 1;
//        result.add("(" + list.get(last) + ")");
//        result.add("()" + list.get(last));
        
        return result;
    }
}
