package algorithms;

public class A59_SpiralMatrixII {
	public static void main(String[] args) {
		A59_SpiralMatrixII a59 = new A59_SpiralMatrixII();
//		int[][] mat = a59.generateMatrix(4);
		int[][] mat = a59.generateMatrix(1);
		for(int i = 0; i<mat.length; i++) {
			for(int j = 0; j<mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public int[][] generateMatrix(int n) {
        
		int[][] mat = new int[n][n];
        int i = 0;
        int j = 0;
        int num = 1;
        while(num <= n * n) {
            mat[i][j] = num;
            //right ->
            if((i == 0 && j < n-1)|| 
            (j < n-1 && mat[i-1][j] > 0 && mat[i][j+1] == 0)) {
                j++;
            //down |
            //     V
            }else if((j == n - 1 && i < n-1) || 
            (i < n-1 && mat[i][j+1] > 0 && mat[i+1][j] == 0)) {
                i++;
            //left <-
            }else if((i == n - 1 && j > 0) ||
            (j > 0 && mat[i+1][j] > 0 && mat[i][j-1] == 0)) {
                j--;
            //down ^
            //     |
            }else if((j == 0 && i > 0) ||
            (i > 0 && mat[i][j-1] > 0 && mat[i-1][j] == 0)) {
            	i--;
            }
            num++;
        }
        
        return mat;
    }
}
