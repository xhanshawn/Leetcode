class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        i = 1
        res = [1]
        p2, p3, p5 = 0, 0, 0
        while(len(res) < n):
            minv = min(res[p2] * 2, min(res[p3] * 3, res[p5] * 5))
            if(minv == res[p2] * 2): p2 += 1
            elif(minv == res[p3] * 3): p3 += 1
            else: p5 += 1
            if(minv > res[-1]): res.append(minv)
            # shouldn't add repeat val
            i += 1
        return res[-1]