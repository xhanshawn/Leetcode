class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        prefix = 1
        for i in xrange(len(nums)):
            res.append(prefix)
            prefix *= nums[i]
        prefix = 1
        for i in xrange(len(nums) - 1, -1, -1):
            res[i] *= prefix
            prefix *= nums[i]
        return res
# very good solution. scan twices