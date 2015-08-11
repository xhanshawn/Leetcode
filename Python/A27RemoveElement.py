class Solution:
    # @param {integer[]} nums
    # @param {integer} val
    # @return {integer}
    def removeElement(self, nums, val):
        p, q = 0, 0
        while(q < len(nums) and p <= q):
            if(nums[q] == val): 
                q += 1
            else:
                if(not p == q): nums[p] = nums[q]
                p += 1
                q += 1
        return p
# Accepted solution

s = Solution()

nums = [1,2,3,3,4,5,4,3,3,2]
print s.removeElement(nums, 4)