class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        one = False
        if(n < 0): return False
        while(not n == 0 and not one):
            if(n & 1 == 1): one = True
            n >>= 1
        return n == 0 and one
# Ac solution
s = Solution()
print s.isPowerOfTwo(3)