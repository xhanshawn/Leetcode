# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        p = self.binarySearch(1, n)
        if(p < n and not isBadVersion(p)): return p + 1
        else: return p
    
    def binarySearch(self, b, e):
        if(b >= e): return b
        m = (b + e)//2
        if(isBadVersion(m)): return self.binarySearch(b, m - 1)
        else: return self.binarySearch(m + 1, e)
    #AC solution