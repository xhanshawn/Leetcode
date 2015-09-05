class Solution(object):
    def countDigitOne(self, n):
        """
        :type n: int
        :rtype: int
        """
        if(n <= 0): return 0
        if(n < 10): return 1

        pot, fst = 1, n
        while(not fst < 10):
            fst /= 10
            pot *= 10
        # first digit is 1 pot is power of 10
        if(fst == 1): return n - pot + 1 + self.countDigitOne(pot - 1) + self.countDigitOne(n % pot)
        else: return pot + fst * self.countDigitOne(pot - 1) + self.countDigitOne(n % pot)

    # def count(self, n):
    #     res = 0
    #     for i in xrange(1, n + 1):
    #         s = str(i)
    #         for c in s:
    #             if(c == '1'): res += 1
    #     return res

# ac solution any way
s = Solution()
for i in xrange(1, 100):
    # a, b = s.count(i), s.countDigitOne(i)
    if(not a == b): print a, b, i







