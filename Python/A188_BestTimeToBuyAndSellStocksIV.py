class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        if(len(prices) < 2): return 0
        if(k > len(prices)/2):
        	res = 0
        	for i in xrange(1, len(nums)): res += max(prices[i] - prices[i - 1], 0)
        	return res
        hold = [-2**32 for _ in xrange(k + 1)]
        sell = [0 for _ in xrange(k + 1)]
        for p in prices:
        	for j in xrange(k, 0, -1):
        		sell[j] = max(sell[j], hold[j] + p)
        		hold[j] = max(hold[j], sell[j - 1] - p)
        return sell[-1]
# concise and nice solution.  hanhongsun's