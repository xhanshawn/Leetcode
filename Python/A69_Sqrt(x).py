class Solution:
    # @param {integer} x
    # @return {integer}
    def mySqrt(self, x):
        p = self.bSearch(1, x, x)
        if(p * p > x and p > 0): return p - 1
        else: return p
    def bSearch(self, b, e, target):
        # print b, e
        if(b >= e): return e
        m = (b + e)/2
        sqr = m * m
        if(sqr == target): return m
        elif(sqr > target): return self.bSearch(b, m, target)
        else: return self.bSearch(m + 1, e, target)
# Accepted solution
s = Solution()
print s.mySqrt(10000000000000000000)