# Definition for a point.
class Point(object):
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b

class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        if(len(points) == 1): return 1
        res = 0
        for i in xrange(len(points)):
            slope = {}
            repeat = 1
            for j in xrange(i + 1, len(points)):
                if(points[i].x == points[j].x and points[i].y == points[j].y): repeat += 1
                else:
                    sl = self.getSlope(points[i], points[j])
                    slope[sl] = slope.get(sl, 0) + 1
            if(not slope.values()): res = max(res, repeat)
            else: res = max(res, max(slope.values()) + repeat)
            # print slope, repeat
        return res
    def getSlope(self, p1, p2):
        difx = (p2.x - p1.x)
        if(difx == 0): return (None, p1.x)
        else:
            k = (p2.y - p1.y) * 1.0/difx
        b = p2.y - p2.x * k
        return k
# accepted solution

s = Solution()
# ps = [Point(1,1), Point(1,1),Point(1,2), Point(2,2), Point(3,3), Point(4,4)]
ps = [Point(0,0), Point(0,0)]
# ps = [Point(3,1), Point(12,3),Point(3,1), Point(-6,-1)]
print s.maxPoints(ps)
        