class Solution:
    # @param {string} s
    # @param {string} t
    # @return {boolean}
    def isAnagram(self, s, t):
        rec = [0 for i in range(26)]
        for c in s:
            rec[ord(c) - ord('a')] += 1
        for c in t:
            rec[ord(c) - ord('a')] -= 1
        for r in rec:
            if(not r == 0): return False
        return True
s = Solution()
print s.isAnagram("cat", "rca")