package algorithms;

import java.util.ArrayList;
import java.util.List;

public class A54_SpiralMatrix {
	
	public static void main (String[] args) {
		
		int[][] matrix = new int[1][0];
		
		//matrix.length = 5
		//matrix[0].length = 6
		System.out.println(matrix.length + "");
		
	}
	
	
	// my solution
	public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<Integer> ();
        
        int m = matrix.length;
        if(m == 0) return list;
        int n = matrix[0].length;
        if(n == 0) return list;
        
        int short_dimension = Math.min(m, n) + 1;        
        
        for(int c=0; c<short_dimension/2; c++) {
            //for the out circle
            
            for(int j= c; j<n - c; j++) {
                
                list.add(matrix[c][j]);
            }
            
            for(int i1=c + 1; i1<m - c; i1++) {
                
                list.add(matrix[i1][n - 1 - c]);
            }
            
            
            // very tricky judge line costs me a long time to figure it out
            // this is for checking it is a whole circle or a half
            // if it is not a whole circle then hop these two iterations
            if(m>=2*(c+1) && n>=2*(c+1)) {
                    
                for(int j2=n-2-c; j2>=c + 1; j2--) {
                
                    list.add(matrix[m - 1 - c][j2]);
                }
                
                
                    
                    
                    
                for(int i2=m-1-c; i2>=c + 1; i2--) {
                
                        list.add(matrix[i2][c]);
                }
            }
        }
        
        
        return list;
    }
	
	// clean code solution. tricky codes in my opinion.
	// no testing for online judge
	// may have typos
	public List<Integer> spiralOrderCleanCode(int[][] matrix) {
		
		List<Integer> elements = new ArrayList<>();
		if (matrix.length == 0) return elements;
		int m = matrix.length, n = matrix[0].length;
		
		int row = 0, col = -1;
		
		while(true) {
			
			for (int i = 0; i < n; i++) {
				elements.add(matrix[row][++col]);
			}
			
			if (--m == 0 ) break;
			
			for (int i = 0; i < m; i++) {
				elements.add(matrix[++row][col]);
			}
			
			if (--n == 0 ) break;
			for (int i = 0; i < n; i++) {
				elements.add(matrix[row][--col]);
			}
			
			if (--m == 0 ) break;
			for (int i = 0; i < m; i++) {
				elements.add(matrix[--row][col]);
			}
			
			if (--n == 0 ) break;
			
		}
		
		return elements;
	}
	
	
}
