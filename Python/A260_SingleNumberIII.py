class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        s1, s2 = set(), set()
        for e in nums:
            if(e in s1 and not e in s2): s2.add(e)
            elif(e not in s1): s1.add(e)
        return list(s1.difference(s2))