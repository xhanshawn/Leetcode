class Solution(object):
    def minCut(self, s):
        dp = [[False if(not i == j) else True for i in xrange(len(s))] for j in xrange(len(s))]
        for l in xrange(1, len(s)):
            for i in xrange(0, len(s) - l):
                j = i + l
                if(l == 1): dp[i][j] = (s[i] == s[j])
                else: dp[i][j] = (s[i] == s[j]) and dp[i+1][j-1]
        cut = [len(s) for x in xrange(len(s))]
        cut[0] = 0
        for p in xrange(1, len(s)):
            if(dp[0][p]): cut[p] = 0
            else: 
                for c in xrange(p, 0, -1):
                    if(dp[c][p]): cut[p] = min(cut[c - 1] + 1, cut[p])
        return cut[-1]

# accepted solution.  sometimes if complexity requirement is not sure, I may be afraid that trying some solution
s = Solution()
st = 'abb'
print s.minCut(st)