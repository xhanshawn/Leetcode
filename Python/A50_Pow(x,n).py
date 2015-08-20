import math
class Solution:
    # @param {float} x
    # @param {integer} n
    # @return {float}
    def myPow(self, x, n):
    	if(n == 0): return 1
        if(n == 1): return x
        if(n == - 1): return 1 / x
        if(n == 2): return x * x
        if(n % 2 == 1):
            return x * self.myPow(self.myPow(x, n//2), 2)
        else:
            return self.myPow(self.myPow(x, n//2), 2)
s = Solution()
print s.myPow(0.00001, 100000000)