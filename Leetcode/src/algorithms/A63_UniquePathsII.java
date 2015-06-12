package algorithms;

public class A63_UniquePathsII {
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int row = obstacleGrid.length;
        if(row == 0) return 0;
        int column = obstacleGrid[0].length;
        
        int[][] matrix = new int[row + 1][column + 1];
        matrix[row - 1][column] = 1;
        for(int i = row-1; i>=0; i--){
            for(int j = column-1; j>=0; j--) {
                
                if(obstacleGrid[i][j] == 1) matrix[i][j] = 0;
                else matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];
            }
        }
        
        
        return matrix[0][0];
    }
}
