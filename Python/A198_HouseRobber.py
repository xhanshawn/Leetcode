class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(len(nums) == 0): return 0
        if(len(nums) == 1): return nums[0]
        if(len(nums) == 2): return max(nums[0], nums[1])

        dp = [0 for _ in xrange(len(nums))]
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in xrange(2, len(nums)):
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        return dp[-1]
# AC solution