class Solution(object):
    def findPeakElement(self, nums):
        p, q = 0, len(nums) - 1
        while(p < q):
            if(nums[p] < nums[q]): p += 1
            else: q -= 1
        return p
# ac solution