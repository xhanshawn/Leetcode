import math
class Solution:
    # @param {integer} n
    # @return {integer}
    # def countPrimes(self, n):
    #     ps = set()
    #     res = 1
    #     for i in range(2, n + 1):
    #         if(self.isPrime(i, ps)):
    #             ps.add(i)
    #             res += 1
    #     return res
    # def isPrime(self, n, ps):
    #     for p in ps:
    #         if(p * p > n): break
    #         if(n % p == 0): return False
    #     return True
    def countPrimes(self, n):
        if(n <= 1): return 0
        ps = [True for i in range(0, n)]
        ps[0], ps[1] = False, False
        i = 2
        while(i * i < n):
            if(ps[i]):
                j = i * i
                while(j < n):
                    ps[j] = False
                    j += i
            i += 1
        res = 0
        for x in range(2, n): 
            if(ps[x]): res += 1
        return res
s = Solution()
# for n in range(2, 10):
print s.countPrimes(100000)