class Solution:
    # @param {integer[]} nums1
    # @param {integer} m
    # @param {integer[]} nums2
    # @param {integer} n
    # @return {void} Do not return anything, modify nums1 in-place instead.
    def merge(self, nums1, m, nums2, n):
        p, q = m - 1, n - 1
        i = m + n - 1
        while(p >=0 and q >= 0):
            if(nums1[p] > nums2[q]):
                nums1[i] = nums1[p]
                p -= 1
            else:
                nums1[i] = nums2[q]
                q -= 1
            i -= 1
        print p, q
        if(p < 0):
            for j in xrange(i + 1):
                nums1[j] = nums2[j]
# Accepted solution
s = Solution()
nums1 = [4,5,6,7,1,1,1]
nums2 = []
s.merge(nums1, 4, nums2, 0)
print nums1