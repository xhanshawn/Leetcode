class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        if(k <= 0 or n / k > 9): return []
        if(k == 1): return [n]
        res = []
        for i in xrange(1, 10):
            r = self.findComb([i], n, n - i, k - 1)
            if(r): res += r
        return res
    
    def findComb(self, c, n, t, k):
        if(k == 0): return [c] if t == 0 else None
        if(t / k > 9): return None
        res = []
        for i in xrange(c[-1] + 1, 10):
            temp = list(c)
            temp.append(i)
            r = self.findComb(temp, n, t - i, k - 1)
            # if(i == 5): print r,t
            if(r): res += r
        return res
# accepted solution. Should read question first every time.

s = Solution()
print s.combinationSum3(3,15)