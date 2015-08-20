class Solution:
    # @param {integer[][]} grid
    # @return {integer}
    def minPathSum(self, grid):
        if(len(grid) == 0): return 0
        dp = [[-1  for i in range(len(grid[0]) + 1)] for j in range(len(grid) + 1)]
        dp[0][1] = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if(dp[i + 1][j] == -1): last = dp[i][j + 1]
                elif(dp[i][j + 1] == - 1): last = dp[i + 1][j]
                else: last = min(dp[i + 1][j], dp[i][j + 1])
                dp[i + 1][j + 1] = last + grid[i][j]
        # print dp
        return dp[-1][-1]
# Accepted Solution
s = Solution()
grid = [[0,1,2,3],[4,5,6,7]]
print s.minPathSum(grid)