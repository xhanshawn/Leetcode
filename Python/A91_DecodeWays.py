class Solution:
    # @param {string} s
    # @return {integer}
    def numDecodings(self, s):
        if(s == ''): return 0
        if(len(s) <= 2): return len(self.decode(s))
        m = (len(s) - 1)/2
        return self.numDecodings(s[:m]) * self.numDecodings(s[m:])
    def decode(self, s):
        if(s == ''): return []
        if(len(s) == 1): return [chr(ord('A') - 1 + int(s))]
        m = (len(s) - 1)/2
        l1 = self.decode(s[:m])
        r1 = self.decode(s[m:])
        l2 = self.decode(s[:m + 1])
        r2 = self.decode(s[m + 1:])
        for i in xrange(len(r1)):
            r1[i] = chr(ord('A') - 1 + int(s[0])) + r1[i]
        if(int(s[:2]) <= 26): 
            if(len(r2) > 0):
                for j in xrange(len(r2)):
                    r2[j] = chr(ord('A') - 1 + int(s[:2])) + r2[j]
            else:
                r2 = [chr(ord('A') - 1 + int(s[:2]))]
            res = r1 + r2
        else: res = r1
        return res
s = Solution()
st2 = "6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155"
st = '123'
# print s.numDecodings(st)
print s.decode(st)





