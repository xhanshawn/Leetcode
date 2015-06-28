package algorithms;

import java.util.ArrayList;
import java.util.List;

public class A77_Combinations {
	public List<List<Integer>> combine(int n, int k) {
        int i = 1;
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        
        while(i < n - k + 2) {
            List<Integer> pre1 = new ArrayList<Integer> ();
            pre1.add(i);
            //i 1
            //j 2
            int j = i + 1;
            //2 < 5
            while(j < n + 1) {
                // p 3
                int p = j;
                //3 < 4
                while(p < j + k - 2) {
                    pre1.add(p);
                    p++;
                }
                
                // 3 < 5
                while(p < n + 1) {
                    List<Integer> list = new ArrayList<Integer> ();
                    list.addAll(pre1);
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
}
