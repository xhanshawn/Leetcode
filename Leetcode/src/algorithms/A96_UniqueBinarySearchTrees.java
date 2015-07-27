package algorithms;

import java.util.ArrayList;
import java.util.List;

import data.TreeNode;

public class A96_UniqueBinarySearchTrees {
	
	public static void main(String[] args) {
		A96_UniqueBinarySearchTrees a96 = new A96_UniqueBinarySearchTrees();
		
		
		System.out.println(a96.numTrees(1));

	}
	
	//for i from 1 to n as a root the possible num is left children possible UTnum of i * right children of i UT num
	
	//at first I tried recursion way. the same result consume so much more than this.
	//accepted solution
	public int numTrees(int n) {
		
		int[] dp = new int[n + 1];
		
		//reset dp[0] = 1 so that will get multiplication of 0
		dp[0] = 1;
		for(int i = 1; i < n + 1; i++){
			for(int j = 1; j <= i; j++){
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		
		return dp[n];
	}
	
//	private boolean isValidBST(List<Integer> list) {
//		if(list.size() <= 1) return true;
//		int left = -1;
//		int right = -1;
//		for(int i = 0; i < list.size() - 1; i++){
//			if(list.get(i) < list.get(list.size() - 1)) {
//				if(left < right && left != -1) return false;
//				left = i;
//			} else if(list.get(i) > list.get(list.size() - 1)) {
//				if(left > right && right != -1) return false;
//				right = i;
//			}
//		}
//		if(right < left && right != -1) return false;
//		if(right == list.size() - 2) return isValidBST(list.subList(0, left + 1)) 
//				&& isValidBST(list.subList(left + 1, list.size() - 1)); 
//		else if(left == list.size() - 2) return isValidBST(list.subList(0, list.size() - 1)); 
//		return false;
//	}
//	
//	private List<List<Integer>> getPerms(int n) {
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		if(n == 1) {
//			List<Integer> list = new ArrayList<Integer>();
//			list.add(1);
//			result.add(list);
//			return result;
//		}
//		List<List<Integer>> last = new ArrayList<List<Integer>>();
//		last = getPerms(n - 1);
//		for(int i = 0; i < last.size(); i++ ){
//			for(int j = 0; j < last.get(0).size(); j++) {
//				if(last.get(i).get(j) < last.get(i).get(last.get(i).size() - 1)) continue;
//				List<Integer> list = new ArrayList<Integer>();
//				list.addAll(last.get(i));
//				list.add(j, n);
//				result.add(list);
//			}
//			List<Integer> list = new ArrayList<Integer>();
//			list.addAll(last.get(i));
//			list.add(n);
//			result.add(list);
//		}
//		
//		return result;
//	}
}
