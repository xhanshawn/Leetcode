class Solution:
    # @param {integer[]} nums
    # @return {void} Do not return anything, modify nums in-place instead.
    # new lexicogrphic order permutaion algorithm from wiki
    
    # 1.Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
    # 2.Find the largest index l greater than k such that a[k] < a[l].
    # 3.Swap the value of a[k] with that of a[l].
    # 4.Reverse the sequence from a[k + 1] up to and including the final element a[n].
    def nextPermutation(self, nums):
        k = -1
        for i in xrange(len(nums) - 1):
            if(nums[i] < nums[i + 1]): k = i
        if(k == -1): 
            nums.sort()
            return 
        j = k + 1
        l = k + 1
        while(j < len(nums)):
            if(nums[j] > nums[k]): l = j
            j += 1
        self.swap(k, l, nums)
        p = k + 1
        q = len(nums) - 1
        while(p < q):
            self.swap(p, q, nums)
            p += 1
            q -= 1
    def swap(self, i, j, nums):
        t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
# Ac solution which proves the importance of writing algorithm first
s = Solution()
nums = [100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1]
s.nextPermutation(nums)
print nums