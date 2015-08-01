class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer}
    def threeSumClosest(self, nums, target):
        if(len(nums) < 3): return 0 
        result = nums[0] + nums[1] + nums[2]
        # offset = abs(result - target)
        nums.sort()
        for i in range(0, len(nums) - 2):
            p = i + 1
            q = len(nums) - 1
            while(p < q):
                s2 = nums[p] + nums[q]
                if(s2 + nums[i] == target): return target
                if(s2 + nums[i] > target):
                    if(s2 + nums[i] - target < abs(result - target)): 
                        result = s2 + nums[i]
                    q -= 1
                else:
                    if(target - s2 - nums[i] < abs(result - target)): 
                        result = s2 + nums[i]
                    p += 1      
        return result
# accepted solution
s = Solution()

nums = [0,1,2,-3]
print s.threeSumClosest(nums, 1)