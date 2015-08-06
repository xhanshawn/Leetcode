class Solution:
    # @param {string} s
    # @return {string[]}
    def findRepeatedDnaSequences(self, s):
        result = []
        se = set()
        if(len(s) >= 10):
            p = 0
            while(p <= len(s) - 10):
                sub = s[p:p + 10]
                if(sub in se and sub not in result): result.append(sub)
                else: se.add(sub)
                p += 1
        return result
s = Solution()
a = "AAAAAAAAAAAA"
print s.findRepeatedDnaSequences(a)