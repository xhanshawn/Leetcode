class Solution(object):
    def maximumGap(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.res = 0
        if(len(nums) < 2): return 0
        if(len(nums) == 2): return abs(nums[1] - nums[0])
        self.mergeSort(nums, 0, len(nums) - 1)
        return self.res

    def mergeSort(self, nums, b, e):
        if(b < e):
            m = (b + e)/2
            self.mergeSort(nums, b, m)
            self.mergeSort(nums, m + 1, e)
            self.merge(nums, b, m + 1, e)
    def merge(self, nums, p, q, r):
        # print p, q, r
        if(p == q): return 
        t = nums[p:q]
        i, j = 0, q
        last = nums[p]
        b = p
        while(i < len(t) and j <= r):
            if(t[i] < nums[j]): 
                nums[p] = t[i]
                i= i + 1
            else:
                nums[p] = nums[j]
                j = j + 1
            if(b == 0 and r == len(nums) - 1):
                # print nums, p
                self.res = max(self.res, nums[p] - last)
                # print self.res, nums[p]
                last = nums[p]
            p += 1
        while(i < len(t)):
            nums[p] = t[i]
            if(b == 0 and r == len(nums) - 1):
                self.res = max(self.res, nums[p] - last)
                # self.res = max(self.res, nums[p] - last)
                last = nums[p]
            i, p = i + 1, p + 1
        while(b == 0 and r == len(nums) - 1 and p < len(nums)):
            self.res = max(self.res, nums[p] - last)
            last = nums[p]
            p += 1
# ac solution.
                
            
        
s = Solution()
nums = [1,2,3,10,8,7]
# s.mergeSort(nums, 0, len(nums) - 1)
print s.maximumGap(nums)
print nums
