class Solution(object):
    def solveNQueens2(self, n):
        # if(n == 1): return ['Q']
        res = []
        for p in xrange(n):
            q = [(0,p)]
            for i in xrange(1,n):
                for j in xrange(n):
                    repeat = False
                    # print i, j
                    for e in q:
                        if(i + j == e[0] + e[1] or i - j == e[0] - e[1] or i == e[0] or j == e[1]): 
                            # if(p == 1 and i == 2): print i + j, i - j, e
                            repeat = True
                            break
                    if(not repeat): q.append((i,j))
            print q
            if(len(q) == n): res.append(q)
        for i in xrange(len(res)):
            res[i] = self.putQueen(res[i])
        return res
    def solveNQueens(self, n):
        self.res = []
        if(n == 1): return [['Q']]
        for j in xrange(n):
            self.solve([(0,j)], 1, n)
        for i in xrange(len(self.res)):
            self.res[i] = self.putQueen(self.res[i])
        return self.res
    def solve(self, q, i, n):
        if(i >= n): return
        que = []
        for j in xrange(n):
            repeat = False
            for e in q:
                if(i + j == e[0] + e[1] or i - j == e[0] - e[1] or i == e[0] or j == e[1]): repeat = True
            if(not repeat): que.append((i, j))
        # print len(que), q
        while(len(que)>0):
            t = list(q)
            t.append(que.pop(0))
            if(i == n - 1 and len(t) == n): self.res.append(t)
            else: self.solve(t, i + 1, n)

    def putQueen(self, r):
        res = []
        for i in xrange(len(r)):
            line = "." * r[i][1] + "Q" + "." * (len(r) - 1 - r[i][1])
            res.append(line)
        return res
# Accepted solution... at first i thought i am wrong cause too many results for n = 8

s = Solution()
# s.solveNQueens(4)
print s.solveNQueens(8)