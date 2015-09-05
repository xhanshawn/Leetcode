class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        if(not nums): return False
        pos = {}
        for i in xrange(len(nums)):
            if(nums[i] in pos): pos[nums[i]].append(i)
            else: pos[nums[i]] = [i]
        nums.sort()
        p, q = 0, 1
        while(q < len(nums)):
            while(p < q and nums[q] - nums[p] > t): p += 1
            i = p
            while(i < q):
                for e1 in pos[nums[q]]:
                    for e2 in pos[nums[i]]:
                        if(abs(e1 - e2) <= k and not e1 - e2 == 0): return True
                i +=1
            q += 1
        return False
# accepted solution
            




s = Solution()
nums = [1,3,1]
print s.containsNearbyAlmostDuplicate(nums, 1, 1)





