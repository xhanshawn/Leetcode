class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        k %= len(nums)
        t = nums[len(nums) - k: len(nums)]
        nums[k:] = nums[:len(nums) - k]
        nums[:k] = t
# ac solution
s = Solution()
nums = [1,2,3,4]
s.rotate(nums, 10)
print nums