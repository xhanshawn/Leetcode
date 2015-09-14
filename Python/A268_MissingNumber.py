class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        last = -1
        for n in nums: 
            if(last < n - 1): return last + 1
            else: last = n
        return nums[-1] + 1