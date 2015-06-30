package algorithms;

import java.util.ArrayList;
import java.util.List;

public class A77_Combinations {
	public static void main(String[] args) {
		
		A77_Combinations a77 = new A77_Combinations();
		for(List<Integer> list : a77.combine(1, 1)) {
			
			for(int x : list) {
				System.out.print(x + " ");
			}
			System.out.println("");
		}
		
	}
	public List<List<Integer>> combine(int n, int k) {
		return combineFrom(1, n, k);
	}
	
	public List<List<Integer>> combine2(int n, int k) {
		
		
        int i = 1;
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        
        //for n = 4, k = 2: i < 4 j < 5
        while(i < n - k + 2) {
            List<Integer> pre = new ArrayList<Integer> ();
            pre.add(i);
            if(k == 1) {
                result.add(pre);
                continue;
            }
            //i 2
            //j 3
            int j = i + 1;
            //3 < 3
            while(j < n + 1 - k + 1) {
                // p 2
                int p = j;
                //2 < 2
                while(j < k - 2 + j) {
                    pre.add(p);
                    p++;
                }
                
                // 2 < 5
                while(p < n + 1) {
                    List<Integer> list = new ArrayList<Integer> ();
                    list.addAll(pre);
                    list.add(p);
                    result.add(list);
                    p++;
                }
                j++;
            }
            i++;
        }
        
        
        return result;
    }
	
	
	private List<List<Integer>> combineFrom(int b, int e, int k) {
		if(e < b) return null;
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(k == 1) {
			for(int i = b; i < e + 1; i++) {
				List<Integer> list = new ArrayList<Integer> ();
				list.add(i);
				result.add(list);
			}
			return result;
		}
		
//		if(e - b + 1 == k) {
//			List<Integer> list = new ArrayList<Integer> ();
//			for(int i = b; i < e + 1; i++) {
//				list.add(i);
//			}
//			result.add(list);
//			return result;
//		}
		
		for(int i = b ; i < e; i++) {
			List<List<Integer>> last = combineFrom(i + 1,e, k - 1);
			
			for(List<Integer> list : last) {
				List<Integer> new_list = new ArrayList<Integer> ();
				new_list.add(i);
				new_list.addAll(list);
				result.add(new_list);
			}
		}
		
		
		return result;
	}
}
