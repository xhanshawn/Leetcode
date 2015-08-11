class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer}
    # def search(self, nums, target):
    #     p, q = 0, len(nums) - 1
    #     while(p <= q):
    #         if(nums[q] == target): return q
    #         if(nums[p] == target): return p

    #         p += 1
    #         q -= 1
    #     return -1


    def search(self, nums, target):
        p = self.bSearch(nums, target, 0, len(nums) - 1)
        if(nums[p] == target): return p
    	else: return -1 
    def bSearch(self, nums, target, b, e):
        if(b >= e): return b
        m = (b + e)//2
        if(nums[b] == target): return b
        if(nums[e] == target): return e
        if(nums[m] == target): return m
        elif(nums[m] >= target and nums[b] < target): 
            return self.bSearch(nums, target, b, m)
        elif(nums[m] <= target and nums[e] > target):
            return self.bSearch(nums, target, m + 1, e)
        else: 
        	return self.bSearch(nums, target, b + 1, e )

      #
     #
    #
    	  #
    	 #
    	#

# two solutions all accepted
s = Solution()
nums = [1, 3, 5]
print s.search(nums, 1)