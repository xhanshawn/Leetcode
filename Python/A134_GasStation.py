class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        # gas[i] > cost[i]
        diff = []
        for i in xrange(len(gas)):
            diff.append(gas[i] - cost[i])
        s = sum(diff)
        if(s < 0): return -1
        tank = 0
        res = -1
        for i in xrange(len(diff)):
        	tank += diff[i]
        	if(tank < 0):
        		tank, res = 0, -1
        	elif(res == -1):
        		res = i
        return res
        	# if(s - diff[i] >= 0 and (i >= len(diff) - 2 or diff[i + 1] + diff[i + 2] > 0 and diff[i + 1] > 0)): 
        	# 	if(i == len(diff) - 1): return 0
        	# 	else: return i + 1
# Accepted solution
s = Solution()
g = [1,2,3,4,5]
c = [3,4,5,1,2]
g = [2,0,1,2,3,4,0]
c = [0,1,0,0,0,0,11]
# g = [1,2]
# c = [2,1]
print s.canCompleteCircuit(g,c)