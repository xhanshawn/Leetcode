class Solution(object):
    # def calculateMinimumHP2(self, dungeon):
    #     """
    #     :type dungeon: List[List[int]]
    #     :rtype: int
    #     """
    #     if(not dungeon): return 0
    #     dp = [[0 for _ in xrange(len(dungeon[0]) + 1)] for _ in xrange(len(dungeon) + 1)]
    #     res = 0
    #     for x in xrange(1, len(dungeon) + 1):
    #         dp[x][0] = None
    #     for x in xrange(2, len(dungeon[0]) + 1):
    #         dp[0][x] = None
    #     ls = [[[] for _ in xrange(len(dungeon[0]) + 1)] for _ in xrange(len(dungeon) + 1)]
    #     for i in xrange(len(dungeon)):
    #         for j in xrange(len(dungeon[0])):
    #             if(dp[i][j + 1] > dp[i + 1][j]):
    #                 dp[i + 1][j + 1] = dp[i][j + 1] + dungeon[i][j]
    #                 ls[i + 1][j + 1] = list(ls[i][j + 1] + [(i + 1,j + 1)])
    #             else:
    #                 dp[i + 1][j + 1] = dp[i + 1][j] + dungeon[i][j]
    #                 ls[i + 1][j + 1] = list(ls[i + 1][j] + [(i + 1,j + 1)])
    #             # res = min(res, dp[i + 1][j + 1] - dungeon[i][j])
    #             # print res, dp[i + 1][j + 1]
    #     # res = min(res, dp[-1][-1])
    #     print dp
    #     print ls[-1][-1]
    #     print ls[2][2]
    #     for pos in ls[-1][-1]:
    #         res = min(res, dp[pos[0]][pos[1]])
    #     res = -res
    #     return res + 1

    # def calculateMinimumHP3(self, dungeon):
    #     if(not dungeon): return 0
    #     dp = [[0 for _ in xrange(len(dungeon[0]) + 1)] for _ in xrange(len(dungeon) + 1)]
    #     res = 0
    #     # for x in xrange(1, len(dungeon) + 1):
    #     #     dp[x][0] = None
    #     # for x in xrange(2, len(dungeon[0]) + 1):
    #     #     dp[0][x] = None
    #     ls = [[[] for _ in xrange(len(dungeon[0]) + 1)] for _ in xrange(len(dungeon) + 1)]
    #     for i in xrange(len(dungeon)):
    #         for j in xrange(len(dungeon[0])):
    #             if(j == 0 or dp[i][j + 1] < dp[i + 1][j] and not i == 0 ):
    #                 dp[i + 1][j + 1] = dp[i][j + 1] - dungeon[i][j]
    #                 ls[i + 1][j + 1] = list(ls[i][j + 1] + [(i + 1,j + 1)])
                
                    
    #             # res = min(res, dp[i + 1][j + 1] - dungeon[i][j])
    #                 # (dungeon[i][j] if dungeon[i][j] < 0 else 0)
    #             else:
    #                 dp[i + 1][j + 1] = dp[i + 1][j] - dungeon[i][j]
    #                 # hp[i + 1][j + 1] = max(hp[i + 1][j], dp[i][j + 1])
    #                 ls[i + 1][j + 1] = list(ls[i + 1][j] + [(i + 1,j + 1)])
    #                 # (dungeon[i][j] if dungeon[i][j] < 0 else 0)
    #     print dp
    #     print ls[-1][-1]
    #     print ls
    #     res = 0
    #     for p in ls[-1][-1]:
    #         res = max(res, dp[p[0]][p[1]])
    #     return res + 1

        # return [-1][-1] + 1
    def calculateMinimumHP(self, dungeon):
        if(not dungeon): return 0
        dp = [0 for _ in xrange(len(dungeon[0]) + 1)]
        dp[-1] = 1
        for i in xrange(len(dungeon[0]) - 1, -1, -1):
            dp[i] = max(1, dp[i + 1] - dungeon[-1][i])
        print dp
        dp[-1] = max(dp[-1], dp[-2])
        # dp value is the min-need hps to save
        for i in xrange(len(dungeon) - 2, -1, -1):
            dp[-2] = max(1, dp[-2] - dungeon[i][-1])
            for j in xrange(len(dungeon[0]) - 2, -1, -1):
                # min of bot and right
                # if dungeon pos and large than next need then wo only need 1 hp
                # if dungeon neg then we need more hp
                dp[j] = max(1, min(dp[j], dp[j + 1]) - dungeon[i][j])
            print dp
        return dp[0]
# accepted solution


s = Solution()
d = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
# d = [[3,-20,30],[-3,4,0]]
# d = [[-200]]
# d = [[-3,5]]
d = [[1],[-2],[1]]
print s.calculateMinimumHP(d)
print s.calculateMinimumHP2(d)