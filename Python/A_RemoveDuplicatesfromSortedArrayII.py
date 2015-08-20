class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def removeDuplicates(self, nums):
        if(len(nums) < 2): return len(nums)
        p, q = 0, 1
        while(q < len(nums)):
            if(nums[q] == nums[p]):
                if(p == 0 or not nums[p - 1] == nums[p]):
                    p += 1
                    if(not p == q): self.swap(p,q,nums)
            else:
                p += 1
                if(not p == q): self.swap(p,q,nums)
            q += 1

        return p + 1
    def swap(self, i, j, nums):
        t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
# Accepted solution
s = Solution()
nums = [1,1,1,2,2,2,2,3]
print s.removeDuplicates(nums)
print nums