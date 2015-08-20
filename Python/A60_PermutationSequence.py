import math
class Solution:
    # @param {integer} n
    # @param {integer} k
    # @return {string}

    # TLE solution
    # def getPermutation(self, n, k):
    #     if(k < 1): return []
    #     return self.permute(n)[k - 1]
    # def permute(self, n):
    #     if(n == 1): return [[1]]
    #     res = []
    #     pre = self.permute(n - 1)
    #     for e in pre:
    #         for i in xrange(len(e), 0, -1):
    #             t = list(e)
    #             t.insert(i, n)
    #             res.append(t)
    #     for e in pre:
    #         t = [n] + list(e)
    #         res.append(t)
    #     return res
    # TLE

#AC solution
    def getPermutation(self, n, k):
        fact = math.factorial(n)
        last = fact
        rec = ""
        for x in xrange(n): rec += str(x + 1)
        res = ""
        while(n > 0):
            last = last/n
            i = (k - 1) / last
            # print k, i, last
            res += rec[i]
            rec = rec[:i] + rec[i + 1:]
            k -= i * last
            n -= 1
        return res
#AC solution

    def getPermutation2(self, n, k):
        res = [i + 1 for i in xrange(n)]
        for i in xrange(k - 1):
            self.nextPermutation(res)
        return str(res)

    def nextPermutation(self, nums):
        k = -1
        for i in xrange(len(nums) - 1):
            if(nums[i] < nums[i + 1]): k = i
        if(k == -1): 
            nums.sort()
            return
        j = k + 1
        l = k + 1
        while(j < len(nums)):
            if(nums[j] > nums[k]): l = j
            j += 1
        self.swap(k, l, nums)
        p = k + 1
        q = len(nums) - 1
        while(p < q):
            self.swap(p, q, nums)
            p += 1
            q -= 1
    def swap(self, i, j, nums):
        t = nums[i]
        nums[i] = nums[j]
        nums[j] = t

s = Solution()
n = 4
# print s.getPermutation2(n,3) 
for x in range(math.factorial(n)):
    print s.getPermutation2(n,x + 1) 

# print s.getPermutation(4,7)



