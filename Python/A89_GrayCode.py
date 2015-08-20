import math
class Solution:
    # @param {integer} n
    # @return {integer[]}
    def grayCode(self, n):
        c = ''
        for i in xrange(n): c += '0'
        s = set()
        s.add(c)
        res = [0]
        po = int(math.pow(2, n))
        for i in xrange(po):
            for p in xrange(len(c) - 1, -1, -1):
                if(c[p] == '1'): t = c[:p] + '0' + c[p + 1:]
                else: t = c[:p] + '1' + c[p + 1:]
                if(t not in s):
                    c = t
                    res.append(self.stoi(c))
                    s.add(c)
                    break
        return res


    def stoi(self, st):
        res = 0
        for c in st:
            res = res * 2 + int(c)
        return res
# Accepted solution
s = Solution()
print s.grayCode(3)
