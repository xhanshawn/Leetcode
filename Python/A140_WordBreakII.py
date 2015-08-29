class Solution(object):
    def wordBreak2(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        dp = [[] for _ in xrange(len(s))]
        dp[0] = ['']
        dicts = [set() for _ in xrange(len(s))]
        for i in xrange(len(s)):
            for j in xrange(i + 1, len(s) + 1):
                # print s[i:j]
                if(s[i : j] in wordDict and s[i : j] not in dicts[i - 1] and (i == 0 or dp[i - 1])): 
                    # print s[i:j]
                    # print i,j
                    dicts[j - 1] = set(dicts[i - 1])
                    dicts[j - 1].add(s[i:j])
                    if(i > 0): 
                        for e in dp[i - 1]:
                            dp[j - 1].append(e + ' ' + s[i : j])
                    else: 
                        if('' in  dp[0]): dp[0].remove('')
                        dp[j - 1].append(s[i : j])
        print dp
        # print dicts
        return dp[-1]

    def wordBreak(self, s, wordDict):
        self.res = []
        self.dfs(s, wordDict, [])
                    
        return self.res
    def dfs(self, s, wordDict, l):
        if(not s or not self.check(s, wordDict)): return
        # print s, l
        for e in wordDict:
            if(s.find(e) == 0):
                t = []
                if(l):
                    for each in l:
                        t.append(each + ' ' + e)
                else: t = [e]
                if(s == e): 
                    self.res.extend(t)
                else:
                    self.dfs(s[len(e):], wordDict, t)
    def check(self, s, wordDict):
        dp = [False for _ in xrange(len(s))]
        for i in xrange(len(s)):
            for j in xrange(i + 1, len(s) + 1):
                dp[j - 1] |= (i == 0 or dp[i - 1]) and (s[i:j] in wordDict)
        return dp[-1]
# Accepted solution dfs is used and a check is avoiding seconde TLE test cases
s = Solution()
l = ["cat", "cats", "and", "sand", "dog"]
d = set(l)
st = "catsanddog"

st2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
l2 = ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
d2 = set(l2)

st = "abcd"
l = ["a","abc","b","cd"]
# l = ["a"]
d = set(l)

print s.wordBreak(st2, d2)
# print s.wordBreak2(st, d)