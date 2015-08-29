import math
class Solution(object):
    # def trailingZeroes(self, n):
    #     if(n == 0): return 0
    #     f = self.fac(1, n)
    #     res = 0
    #     while(f % 10 == 0):
    #         f /= 10
    #         res += 1
    #     return res
        
    # def fac(self, i, j):
    #     if(i == j): return i
    #     if(i >= j - 1): return i * j
    #     m = (i + j)/2
    #     return self.fac(i, m) * self.fac(m + 1, j)

    def trailingZeroes(self, n):
        f = 1
        res = 0
        while(n >= 5 ** f):
            res += n/(5 ** f)
            f += 1
        return res
# count number of 5

s = Solution()

# print s.trailingZeroes(2527)
for x in xrange(100):
    print s.trailingZeroes(x), x
print 2 ** 5