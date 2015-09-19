class Solution(object):
    def getSkyline(self, buildings):
        """
        :type buildings: List[List[int]]
        :rtype: List[List[int]]
        """
        if(not buildings): return buildings
        ps = []
        for b in buildings: ps.append([[b[0], b[2]], [b[1], 0]])
        return self.mergeAll(ps)
    def mergeAll(self, ps):
        if(len(ps) > 1):
            l = self.mergeAll(ps[ : len(ps)//2])
            r = self.mergeAll(ps[len(ps)//2 : ])
            return self.merge(l,r)
        else: return ps[0]
    def merge(self, l, r):
        res = []
        i, j = 0, 0
        h1, h2 = 0, 0
        while(i < len(l) and j < len(r)):
            lp, rp = l[i][0], r[j][0]
            if(lp <= rp):
                p, h1, i = lp, l[i][1], i + 1
            if(lp >= rp):
                p, h2, j = rp, r[j][1], j + 1
            h = max(h1, h2)
            if(not res or not res[-1][1] == h):
                res.append([p, h])
        res += l[i:] if i < len(l) else r[j:]
        return res
# accepted solution. Tried many ways to solve it. At last, I found the way I used first is tht way to this way solution.


s = Solution()
bs = [[0,2147483647,2147483647]]
bs = [ [2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8] ]
bs = [[0,2,3],[2,5,3]]
# bs2 = [[0,3,3],[1,5,3],[2,4,3],[3,7,3]]
print s.getSkyline(bs)
# print s.merge([[2,10],[9,0]], [[3,15],[7,0]])