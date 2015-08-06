class Solution:
    # @param {string} s
    # @return {string[]}
    def restoreIpAddresses(self, s):
        return self.restore(s, 4)
    def restore(self, s, cut):
        result = []
        # print s, cut
        if(len(s) == 0): return result
        if(cut == 1): 
            if(s[0] == '0' and len(s) > 1): return result
            num = int(s)
            if(len(s) <= 3 and num <= 255): 
                result.append(s)
            return result
        if(len(s) <= cut * 3):
            if(s[0] == '0'): 
                tail = self.restore(s[1:], cut - 1)
                for t in tail:
                    result.append(s[0] + "." + t)
            else:
                p = 1
                while(p < 4):
                    num = int(s[:p])   
                    if(num < 256): 
                        tail = self.restore(s[p:], cut - 1)
                        for t in tail:
                            result.append(s[:p] + "." + t)
                    p += 1
        return result
# accepted solution. edge cases like 0
s = Solution()
aa = "25525511135"
aa = "010010"
print s.restoreIpAddresses(aa)



