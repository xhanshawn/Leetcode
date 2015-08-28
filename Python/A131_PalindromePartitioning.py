class Solution(object):
    def partition(self, s):
        # if(len(s) == 0): return []
        # if(len(s) == 1): return [[s]]
        res = []
        if(self.isPalin(s)): res.append([s])
        for i in xrange(1, len(s)):
            if(self.isPalin(s[:i])):
                r2 = self.partition(s[i:])
                for e in r2:
                    res.append([s[:i]] + e)
        # if(self.isPalin(s)):
        #     res.append([s])
        return res
                    
            
    def isPalin(self, s):
        if(len(s) == 0): return False
        if(len(s) == 1): return True
        if(len(s) == 2): return (s[0] == s[1])
        i, j = 0, len(s) - 1
        while(i <= j):
            if(not s[i] == s[j]): return False
            i, j = i + 1, j - 1
        return True
# Accepted solution
s = Solution()
st = "ababbbabbaba"
st = 'dde'
# st = "kwtbjmsjvbrwriqwxadwnufplszhqccayvdhhvscxjaqsrmrrqngmuvxnugdzjfxeihogzsdjtvdmkudckjoggltcuybddbjoizu"
# st = 'bb'
print s.partition(st)
# print s.isPalin('abbaba')