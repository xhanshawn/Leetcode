class Solution:
    # @param {string} s
    # @return {integer}
    def lengthOfLastWord(self, s):
        ss = s.split()
        if(len(ss) == 0): return 0
        return len(ss[-1])
s = Solution()
st = "Hello world"
print s.lengthOfLastWord(st)