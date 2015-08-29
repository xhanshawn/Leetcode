class Solution(object):
    def rangeBitwiseAnd(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        i = 0
        while(not m == n):
            m >>= 1
            n >>= 1
            i += 1
        return n << i
# accepted solution
s = Solution()
print s.rangeBitwiseAnd(3, 7)