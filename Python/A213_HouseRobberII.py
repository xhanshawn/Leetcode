class Solution(object):
    # def rob2(self, nums):
    #     """
    #     :type nums: List[int]
    #     :rtype: int
    #     """
    #     if(not nums): return 0
    #     if(len(nums) == 1): return nums[0]
    #     if(len(nums) == 2): return max(nums[0], nums[1])

    #     dp = [0 for _ in xrange(len(nums))]
    #     use0 = [False for _ in xrange(len(nums))]
    #     use0[0] = True
    #     dp[0] =  nums[0]
    #     if(nums[1] >= nums[0]): dp[1] = nums[1]
    #     else: 
    #         dp[1] = nums[0]
    #         use0[1] = True
    #     for i in xrange(2, len(nums) - 1):
    #         if(dp[i - 2] + nums[i] > dp[i - 1] or dp[i - 2] + nums[i] == dp[i - 1] and use0[i - 1]):
    #             dp[i] = dp[i - 2] + nums[i]
    #             use0[i] = use0[i - 2]
    #         else:
    #             dp[i] = dp[i - 1]
    #             use0[i] = use0[i - 1]
    #     print use0
    #     print dp
    #     if(dp[-3] + nums[-1] > dp[-2] and not use0[-3]): return dp[-3] + nums[-1]
    #     else: return dp[-2]


    def rob(self, nums):
        if(not nums): return 0
        if(len(nums) == 1): return nums[0]
        if(len(nums) == 2): return max(nums[0], nums[1])

        dp = [0 for _ in xrange(len(nums))]
        dp[0] =  nums[0]
        dp[1] = max(nums[1], nums[0])
        for i in xrange(2, len(nums) - 1):
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        has0 = dp[-2]
        print dp
        dp[1] = nums[1]
        dp[2] = max(nums[1], nums[2])
        for i in xrange(3, len(nums)):
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        return max(has0, dp[-1])
        
    # ac solution

s = Solution()
ns = [2,7,9,3,1]
ns = [1,1,1,2]
# ns = [6,6,4,8,4,3,3,10]
# ns = [1,1,3,6,7,10,7,1,8,5,9,1,4,4,3]
print s.rob(ns)