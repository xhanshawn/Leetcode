class Solution(object):
    def generate(self, numRows):
        if(numRows < 1): return []
        res = [self.getNext([])]
        if(numRows == 1): return res
        for i in xrange(1, numRows):
            res.append(self.getNext(res[-1]))
        return res
        
    def getNext(self, l):
        if(len(l) == 0): return [1]
        if(len(l) == 1): return [1,1]
        res = [1]
        for i in xrange(len(l) - 1):
            res.append(l[i] + l[i + 1])
        res.append(1)
        return res
# Accepted solution
s = Solution()
print s.generate(5)