package algorithms;

public class A62_UniquePaths {

	private int M, N;
    
	public static void main (String[] args) {
		
		A62_UniquePaths a62 = new A62_UniquePaths();
		System.out.println("" + a62.uniquePaths(1, 2));
		System.out.println("" + a62.uniquePaths(3, 7));
		System.out.println("" + a62.uniquePaths(3, 3));

		
	}
	
	//correct optimized solution using dynamic programming
    public int uniquePaths(int m, int n) {
       
//       M = m;
//       N = n;
//       return findPaths(1, 1) + 1;
    	
    	int right, down;
    	
    	//one more row and column for starting from finish point
    	int[][] matrix = new int [m+1][n+1];
    	
    	
    	//start from finish's right or down
    	matrix[m-1][n] = 1;
    	for(int i=m-1; i>=0; i--) {
    		for(int j=n-1; j>=0; j--) {
    			 matrix[i][j] = matrix[i][j+1] + matrix[i+1][j];
    		}
    	}
    	
    	return matrix[0][0];
    }
    
    private int findPaths(int m,int n) {
        
        if(m > M || n > N) return 0;
        if(m == M && n == N) return 0;
        
        int right = findPaths(m, n + 1);
        int down = findPaths(m + 1, n);
        
        if(m == M ^ n == N) return down + right;
        else return right + down + 1;
    }
}
