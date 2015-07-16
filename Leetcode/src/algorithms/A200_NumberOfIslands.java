package algorithms;

public class A200_NumberOfIslands {
	public static void main (String[] args) {
		A200_NumberOfIslands a200 = new A200_NumberOfIslands();
		
		char[][] grid = new char[][]{
			{'1','1','0','0','0'},
			{'1','1','0','0','0'},
			{'0','0','1','0','0'},
			{'0','0','0','1','1'}
		};
		
//		char[][] grid = new char[][]{
//			{'1','1','1'},
//			{'0','1','0'},
//			{'1','1','1'},
//		};
        System.out.println(a200.numIslands(grid) + "");
	}
	
	
	//276ms accepted solution based on dfs. 
	//top performance in java :)
	int[][] visited;
    
	public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        visited = new int[grid.length][grid[0].length];
        int is = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
            	if(visited[i][j] == 0 && grid[i][j] == '1') {
            		dfs(grid, i, j);
            		is++;
            	}
            }
        }
        return is;
    }
	
	private void dfs(char[][] grid, int i, int j) {
		visited[i][j] = 1;
		//up
		if(i > 0 && visited[i - 1][j] == 0 && grid[i - 1][j] == '1') 
			dfs(grid, i - 1, j);
		//left
		if(j > 0 && visited[i][j - 1] == 0 && grid[i][j - 1] == '1') 
			dfs(grid, i, j - 1);
		if(i < grid.length - 1 && visited[i + 1][j] == 0 && grid[i + 1][j] == '1') 
			dfs(grid, i + 1, j);
		if(j < grid[0].length - 1 && visited[i][j + 1] == 0 && grid[i][j + 1] == '1') 
			dfs(grid, i, j + 1);
	}
}
