class Solution(object):
    def totalNQueens(self, n):
        self.res = []
        if(n == 1): return 1
        for j in xrange(n):
            self.solve([(0,j)], 1, n)
        return len(self.res)
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

#accepted solution, just modify a little from A51