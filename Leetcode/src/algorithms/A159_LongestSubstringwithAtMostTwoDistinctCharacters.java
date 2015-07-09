package algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A159_LongestSubstringwithAtMostTwoDistinctCharacters {
	public static void main (String[] args) {
		A159_LongestSubstringwithAtMostTwoDistinctCharacters a159 = new A159_LongestSubstringwithAtMostTwoDistinctCharacters();
		System.out.println(a159.a159("eceeeeeee"));
		System.out.println(a159.a159("eceaeeeee"));
		System.out.println(a159.a159("abcddedddd"));

		System.out.println(a159.solution("eceeeeeee"));
		System.out.println(a159.solution("eceaeeeee"));
		System.out.println(a159.solution("abcddedddd"));
		int k = 1;
		System.out.println(a159.forKDistinct("eceeeeeee", k));
		System.out.println(a159.forKDistinct("eceaeeeee", k));
		System.out.println(a159.forKDistinct("abcddedddd", k));

	}
	
	public int a159(String s) {
		
		int pi = 0;
		int pj = 0;
		int[] ch_rec = new int[256];
		int distinct = 0;
		char fst = 0;
		char sec = 0;
		int max = 0;
		Arrays.fill(ch_rec, -1);
		
		while (pj < s.length()) {
			char current  = s.charAt(pj);
			if(ch_rec[current] < pi) {
				
				if(distinct >= 2) {
					pi = ch_rec[fst] + 1;
					fst = sec;
					sec = current;
				}else {
					if(distinct == 0) fst = current;
					if(distinct == 1) sec = current;
					distinct ++;
				}
				
			}
			ch_rec[current] = pj;
			max = Math.max(pj - pi + 1, max);
			pj++;
		}
		
		return max;
	}
	
	public int solution(String s) {
		int pi = 0;
		int pj = 1;
		int first = -1;
		int max = 0;
		while (pj < s.length()) { 
			
			if(s.charAt(pj) != s.charAt(pj - 1)) {
				if(first > 0 && s.charAt(first) != s.charAt(pj)) {
					pi = first + 1;
				}
				first = pj - 1;
				max = Math.max(pj - pi + 1, max);

			}
			pj++;
		}
		//better than get max in each iteration.
		//get length only when a new distinct character appears or meets the end
		return Math.max(pj - pi, max);
	}
	
	
	public int forKDistinct(String s, int k) {
		
		if(k<1 || k>256) return 0;
		
		int pi = 0;
		int pj = 0;
		int[] ch_rec = new int[256];
		int distinct = 0;
		Queue<Character> q = new LinkedList<Character>();
		
		int max = 0;
		Arrays.fill(ch_rec, -1);
		
		while (pj < s.length()) {
			char current  = s.charAt(pj);
			if(ch_rec[current] < pi) {
				
				if(distinct >= k) {
					pi = ch_rec[q.poll()] + 1;
					
				}else {
					distinct ++;
				}
				q.add(current);
			}
			ch_rec[current] = pj;
			max = Math.max(pj - pi + 1, max);
			pj++;
		}
		
		return max;
	}
}
