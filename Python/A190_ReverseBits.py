class Solution(object):
    def reverseBits(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = 0
        i = 0
        while(not n == 0):
        	d = n & 1
        	print d
        	res = res * 2 + d
        	n >>= 1
        	i += 1
        res *= 2 ** (32 - i)
        return res
# Accepted solution
s = Solution()
print s.reverseBits(43261596)