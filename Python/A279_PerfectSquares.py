class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        q = [(0, 0)]
        visited = set()
        while(q):
            i, step = q.pop(0)
            for j in xrange(1, n + 1):
                r = i + j ** 2
                if(r > n): break
                elif(r == n): return step + 1
                elif(r < n and r not in visited):
                    visited.add(r)
                    q.append((r, step + 1))
#BFS