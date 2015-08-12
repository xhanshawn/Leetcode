import copy
class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def removeDuplicates(self, nums):
    	p, q = 0, 0
    	while(q < len(nums)):
    		if(q > 0 and nums[q - 1] == nums[q]): 
    		    q += 1
    		    continue
    		if(not p == q): nums[p] = nums[q]
    		p += 1
    		q += 1
    	return p
# accepted solution
s = Solution()
nums = [1,1,2]
print s.removeDuplicates(nums)
print nums