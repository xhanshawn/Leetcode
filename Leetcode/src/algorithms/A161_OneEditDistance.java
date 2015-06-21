package algorithms;

public class A161_OneEditDistance {
	public static void main(String[] args) {
	}
	
	public boolean isOneEditDistance(String m, String n){
		int dis = 0;
		if(m.length() > n.length()) return isOneEditDistance(n, m);
		if(m.length() == n.length()) {
			
			int p = 0;
			while(p<m.length()) {
				if(m.charAt(p) != n.charAt(p)) dis++;
				p++;
			}
			return dis<=1;
		}
		
		if(m.length() == n.length() -1) {
			
			int pi = 0;
			int pj = 0;
			boolean added = false;
			while(pi < m.length() && pj < n.length()) {
				if(m.charAt(pi) != n.charAt(pj)) {
					if(added) return false;
					pj++;
					added = true;
				}
				
				return pi == m.length();
			}
			
			
			
		}
		
		return false;
		
	}
	
	// very concise codes
	// only single iteration
	public boolean solution(String s, String t) {
		int m = s.length(), n = t.length();
		if(m > n) return solution(t, s);
		if(n - m > 1) return false;
		int i = 0, shift = n - m;
		
		//identical part
		while(i<m && s.charAt(i) == t.charAt(i)) i++ ;
		//totally equal is not true
		//need exactly one edit distance
		if(i == m) return shift > 0;
		//one modification
		if(shift == 0) i++ ;
		//one insert or append
		while(i<m && s.charAt(i) == t.charAt(i + shift)) i++ ;
		return i == m;
	}
}
