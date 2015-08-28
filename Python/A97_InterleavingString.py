class Solution(object):
    def isInterleave(self, s1, s2, s3):
        if(not len(s1) + len(s2) == len(s3)): return False
        if(len(s1) == 0): return s2 == s3
        if(len(s2) == 0): return s1 == s3
        
        dp = [[False for i in xrange(len(s2) + 1)] for j in xrange(len(s1) + 1)]
        dp[0][0] = (s1[0] + s2[0] == s3[:2]) or (s2[0] + s1[0] == s3[:2])
        for i in xrange(len(s1)):
            dp[i + 1][0] = s1[:i + 1] == s3[:i + 1]
        for j in xrange(len(s2)):
            dp[0][j + 1] = s2[:j + 1] == s3[:j + 1]
        for i in xrange(len(s1)):
            for j in xrange(len(s2)):
                dp[i + 1][j + 1] = dp[i][j + 1] and s1[i] == s3[i + j + 1] or dp[i + 1][j] and s2[j] == s3[i + j + 1] or dp[i][j] and (s1[i] + s2[j] == s3[i + j: i + j + 2] or s2[j] + s1[i] == s3[i + j: i + j + 2])
        return dp[-1][-1]
# accepted solution classic two-D dp for string comparison
s = Solution()
s1 = 'aabcc'
s2 = 'dbbca'
s3 = 'aadbbcbcac'
s3 = 'aadbbbaccc'
s1 = 'aabccabc'
s2 = 'dbbabc'
s3 = 'aabdbbccababcc'
print s.isInterleave(s1, s2, s3)