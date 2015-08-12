class Solution:
    # @param {string} digits
    # @return {string[]}
    def letterCombinations(self, digits):
        self.n2s = ['abc','def','ghi','jkl','mno','pqrs','tuv','wxyz']
        return self.convert(digits)
    def convert(self, s):
        print s
        if(len(s) == 0): return []
        if(len(s) == 1):
            return list(self.n2s[int(s) - 2])
        sec = self.convert(s[1:])
        res = []
        for each in sec:
            for c in self.n2s[int(s[0]) - 2]:
                t = c + each
                res.append(t)
        return res
# Accepted Solution
s = Solution()
res = s.letterCombinations('234')
print res
ans = ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
for a in ans:
    if(a not in res): print a