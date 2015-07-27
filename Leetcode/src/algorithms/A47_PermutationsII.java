package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class A47_PermutationsII {
	public static void main(String[] args) {
		A47_PermutationsII a47 = new A47_PermutationsII();
		List<List<Integer>>res = a47.permuteUnique(new int[] {1, 2, 1});
//		result = a47.permuteUnique(new int[] {3,3,0,3});
		System.out.println(res);

		System.out.println(res.size());
	}
	
	//accepted solution reference the idea from discussion 
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> permuteUnique(int[] nums) {
		
	    if(nums.length == 0) return result; 
	    List<Integer> N = new ArrayList<Integer> ();
	    
	    for(int i : nums) N.add(i);
	    N.sort(null);
		permute(N, 0);
	    return result;
	}
	
	private void permute(List<Integer> N, int p) {
		if(p == N.size() - 1) {
			List<Integer> list = new ArrayList<Integer>();
			list.addAll(N);
			result.add(list);
			return;
		}
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = p; i < N.size(); i++) {
			if(!set.contains(N.get(i))) {
				permute(swap(N, p, i), p + 1);
				N = swap(N, p, i);
				set.add(N.get(i));
			}
		}
	}
	
	private List<Integer>  swap(List<Integer> N, int i, int j) {

		int t2 = N.get(j);
		int t1 = N.get(i);
		N.remove(i);
		N.add(i, t2);
		N.remove(j);
		N.add(j, t1);
		return N;
	}

	
	
//	private List<int[]> getPosition(int p, int n, int l) {
//		
//		List<int[]> positions = new ArrayList<int[]>();
//		if(p == 0) return positions;
//		if(n == 0) {
//			int[] P = new int[l];
//			positions.add(P);
//			return positions;
//		}
//		for(int i = 0; i < l; i ++) {
//			List<int[]> last = getPosition(p - 1, n - 1, l);
//			for(int[] P : last) {
//				int[] temp = P;
//				temp[i]++;
//				positions.add(temp);
//			}
//		}
//		return positions;
//	}
//	
//	private List<List<Integer>> insertMulti(List<List<Integer>> lists, int i) {
//		
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		if(lists.size() == 0) {
//			List<Integer> list = new ArrayList<Integer>();
////			for(int t = 0; t < n ;t ++) 
//				list.add(i);
//			result.add(list);
//			return result;
//		}
//		
//		int last_size = lists.get(0).size();
//		while(lists.get(0).size() == last_size) {
//			System.out.println(lists);
//
//			for(int p = 0; p <= lists.get(0).size(); p ++) {
//				if(p > 0 && lists.get(0).get(p - 1) == i) continue;
////				if(p < lists.get(0).size() - 1 && lists.get(0).get(p + 1) == i) continue;
//				List<Integer> list =  new ArrayList<Integer>();
//				list.addAll(lists.get(0));
//				list.add(p, i);
//				lists.add(list);
//				while(p < lists.get(0).size() && lists.get(0).get(p) == i) p++;
//			}
//			lists.remove(0);
//		}
//		
//		
//		return lists;
//	}
//	
////	private List<List<Integer>> insertMulti(List<List<Integer>> lists, int i, int n){
////		List<List<Integer>> result = new ArrayList<List<Integer>>();
////		int p = 0;
////		if(lists.size() == 0) {
////			List<Integer> list = new ArrayList<Integer>();
////			for(int t = 0; t < n ;t ++) list.add(i);
////			result.add(list);
////			return result;
////		}
////		
////		for(List<Integer> l : lists) {
////			while(p <= l.size()) {
////
////				int num1 = n - 1;
////				int q = p;
////				int num2 = 1;
////				while(num2 < n) {
////					num1 = n - num2;
//					q = p;
//					while(q <= l.size()) {
//						List<Integer> list = new ArrayList<Integer>();
//						list.addAll(l);
//						for(int t = 0; t < num1; t++) list.add(p, i);
//						for(int t = 0; t < num2; t++) list.add(q + num1, i);
//						result.add(list);
//						q++;
//					}
//					num2++;
//				}
//				p++;
//			}
//		}
//		
//		return result;
//	}
}
