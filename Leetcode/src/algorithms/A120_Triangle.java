package algorithms;

import java.util.ArrayList;
import java.util.List;

public class A120_Triangle {
	
	public static void main(String[] args) {
		List<Integer> r1 = new ArrayList<Integer> ();
		r1.add(2);
		List<Integer> r2 = new ArrayList<Integer> ();
		r2.add(3);
		r2.add(4);
		List<Integer> r3 = new ArrayList<Integer> ();
		r3.add(6);r3.add(5);r3.add(7);
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(r1); triangle.add(r2);triangle.add(r3);
		A120_Triangle a120 = new A120_Triangle();
		System.out.println(a120.minimumTotal(triangle));
	}
	
	//accepted
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);
        List<List<Integer>> sums = new ArrayList<List<Integer>>();
        sums.add(triangle.get(triangle.size() - 1));
        for(int i = triangle.size() - 2; i >= 0; i--){
            List<Integer> row = triangle.get(i);
            List<Integer> below = sums.get(0);
            List<Integer> sum = new ArrayList<Integer>();
            for(int j = 0; j < row.size(); j++){
                int l = below.get(j);
                int r = below.get(j + 1);
                sum.add(row.get(j) + Math.min(l,r));
            }
            sums.add(0, sum);
        }
        return sums.get(0).get(0);
    }
}
