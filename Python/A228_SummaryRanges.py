class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        if(not nums): return nums
        res = []
        i = 0
        while(i < len(nums)):
            start = nums[i]
            st = str(start)
            p = i
            while(p + 1 < len(nums) and nums[p + 1] == nums[i] + p + 1 - i): p += 1
            if(p == i): res.append(st)
            else:
                st += "->" + str(nums[p])
                res.append(st)
            i = p + 1
        return res
# AC solution easy problem.



s = Solution()
nums = [0,1,2,4,5,7]
print s.summaryRanges(nums)