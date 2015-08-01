class Interval:
	def __init__(self, s = 0, e = 0) :
		self.start = s
		self.end = e

class Solution:
    # @param {Interval[]} intervals
    # @return {Interval[]}
    def merge(self, intervals):
    	result = []
    	if(not intervals): return result
    	# intervals = self.bSort(intervals)
    	intervals.sort(key=lambda x: x.start)
    	result.append(intervals[0])
    	p = 1
    	while(p < len(intervals)):
    		if(intervals[p].start <= result[len(result) - 1].end): 
				result[len(result) - 1].end = max(intervals[p].end, result[len(result) - 1].end)
    		else: result.append(intervals[p])
    		p += 1
    	return result

    def bSort(self, intervals):
    	result = []
    	for interval in intervals:
    		p = self.bSearch(interval.start, result, 0, len(result) - 1)
    		print p, interval.start
    		if(p > 0 and result[p].start >= interval.start):result.insert(p, interval)
    		else: result.insert(p + 1, interval)
    	return result

    def bSearch(self, val, result, b, e):
    	if(b >= e): return e
    	m = (b + e)/2
    	if(result[m] == val): return m
    	elif(result[m] > val): return self.bSearch(val, result, b, m)
    	else : return self.bSearch(val, result, m + 1, e)
#accepted solution
#lambda function is a new knowledge point
s = Solution()
intervals = []
intervals.append(Interval(1,4))
intervals.append(Interval(0,5))
result = s.merge(intervals)
for i in result: print i.start, i.end