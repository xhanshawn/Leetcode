class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        c = [1]
        for i in xrange(1,len(ratings)):
            if(ratings[i] > ratings[i - 1]): c.append(c[-1] + 1)
            else: c.append(1)
        # print c
        for i in xrange(len(ratings) - 1, 0, - 1):
            if(ratings[i] < ratings[i - 1]): c[i - 1] = max(c[i - 1],c[i] + 1)
        # print c
        return sum(c)
#....Ac solution... is this a hard level?...
        
s = Solution()
r = [2,1]
print s.candy(r)