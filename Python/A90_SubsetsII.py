class Solution(object):
    def subsetsWithDup(self, nums):
        nums.sort()
        res = [[]]
        if(len(nums) == 0): return res
        # if(len(nums) == 1): 
        #     res.append([nums[0]])
        #     return res
        start = 1
        res.append([nums[0]])
        while(start < len(nums) and nums[start - 1] == nums[start]): 
            start += 1
            res.append(nums[:start])
        i = start
        # print res, start
        while(i < len(nums)):
            t = []
            for e in res:
                # print nums[i]
                t.append(e + [nums[i]])
            i += 1
            while(i < len(nums) and nums[i - 1] == nums[i]): 
                i += 1
                for e in res:
                    # print nums[start:i]
                    t.append(e + nums[start:i])
            res.extend(t)
            start = i
        # print res, start
        return res
#accepted solution

s = Solution()
nums = [1,2,2,2]
print s.subsetsWithDup(nums)