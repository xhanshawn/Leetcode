class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        if(len(nums) == 0): return False
        p, q = 0, 0
        s = set()
        while(q < k and q < len(nums)):
            if(nums[q] in s): return True
            s.add(nums[q])
            q += 1
        # s.remove(nums[p])
        while(q < len(nums)):
            # print s, p, q
            if(nums[q] in s): return True
            s.add(nums[q])
            if(nums[p] in s): s.remove(nums[p])
            p, q = p + 1, q + 1
        return False
# accepted solution
s = Solution()
nums = [-1,-1]
k = 1
print s.containsNearbyDuplicate(nums, k)