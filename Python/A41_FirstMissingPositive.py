class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def firstMissingPositive(self, nums):
        s = set()
        fir = 1
        for num in nums:
            if(num > fir): s.add(num)
            elif(num == fir): 
                fir += 1
                while(fir in s): fir += 1
        return fir
s = Solution()
nums = [2, 1]
print s.firstMissingPositive(nums)