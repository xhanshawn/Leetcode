class Solution(object):
    def getRow(self, rowIndex):
        if(rowIndex < 0): return []
        res = [self.getNext([])]
        if(rowIndex == 0): return res[-1]
        for i in xrange(1, rowIndex + 1):
            res.append(self.getNext(res[-1]))
        return res[-1]
        
    def getNext(self, l):
        if(len(l) == 0): return [1]
        if(len(l) == 1): return [1,1]
        res = [1]
        for i in xrange(len(l) - 1):
            res.append(l[i] + l[i + 1])
        res.append(1)
        return res