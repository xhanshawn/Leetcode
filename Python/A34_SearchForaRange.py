class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[]}
    def searchRange(self, nums, target):
        p = self.bSearch(0, len(nums) - 1, nums, target)
        if(nums[p] == target):
            i, j = p, p
            while(i - 1 >= 0 and nums[i - 1] == target): i -= 1
            while(j + 1 < len(nums) and nums[j + 1] == target): j += 1
            return [i, j]
        else: return [-1, -1]

    def bSearch(self, b, e, nums, target):
        if(b >= e): return b
        m = (b + e) /2
        if(nums[m] == target): return m
        if(nums[m] > target): return self.bSearch(b, m, nums, target)
        else: return self.bSearch(m + 1, e, nums, target)
# Accepted solution
s = Solution()
nums = [5, 7, 7, 8, 8, 10]
target = 5
print s.searchRange(nums, target)