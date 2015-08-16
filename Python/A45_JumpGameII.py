class Solution:
    # @param {integer[]} nums
    # @return {integer}
    # pick next step with larger nums and then add count
    def jump(self, nums):
        if(len(nums) <= 1): return 0
        visited = set()
        i = 0
        count = 0
        while(i < len(nums) - 1):
            if(i in visited): 
                return 0
            visited.add(i)
            m = 0
            m_num = 0
            for j in range(nums[i] + 1):
                if(i + j >= len(nums) - 1): 
                    return count + 1
                if(i + j + nums[i + j] > m): 
                    m = i + j + nums[i + j]
                    m_num = nums[i + j]
            i = m - m_num
            count += 1
        return count + 1
# Accepted solution

s = Solution()
nums = [5,9,3,2,1,0,2,3,3,1,0,0]
print s.jump(nums)