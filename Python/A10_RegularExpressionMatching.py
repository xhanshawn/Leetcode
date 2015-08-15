class Solution:
    # @param {string} s
    # @param {string} p
    # @return {boolean}
    def isMatch(self, s, p):
        fst = [True]
        for c in p:
            if(c == '*'): fst.append(fst[-2])
            else: fst.append(False)
        dp = [[False for x in range(len(p) + 1)] for x in range(len(s) + 1)]
        dp[0] = fst
        for i in xrange(len(s)):
            for j in xrange(len(p)):
                if(not p[j] == '*'):
                    # match when former substring match and current match or p[j] is '.'
                    dp[i + 1][j + 1] = dp[i][j] and (s[i] == p[j] or p[j] == '.')
                else:
                    # s former one match or former two match p last two or one 
                    former = dp[i + 1][j - 1] or dp[i + 1][j]
                    # all last one match and s now match p last one
                    last_two = dp[i][j] and (s[i] == p[j - 1] or p[j - 1] == '.')
                    # s last one match p now and s now match p last
                    last_one = dp[i][j + 1] and (s[i] == p[j - 1] or p[j - 1] == '.')
                    dp[i + 1][j + 1] = former or last_two or last_one
        return dp[-1][-1]
# 
s = Solution()
print s.isMatch("aa","a")
print s.isMatch("aa","aa")
print s.isMatch("aaa","aa")
print s.isMatch("aa", "a*")
print s.isMatch("aaa", ".*")
print s.isMatch("ab", ".*")
print s.isMatch("ab", ".*c")
print s.isMatch("aab", "c*a*b")
print s.isMatch("aaa", "ab*ac*a")
print s.isMatch("aaa", "ab*a")
print s.isMatch("aaba", "ab*a*c*a")
print s.isMatch("aaa", "ab*a*c*a")


