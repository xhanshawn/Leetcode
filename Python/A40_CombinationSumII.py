class Solution:
    # @param {integer[]} candidates
    # @param {integer} target
    # @return {integer[][]}

    # sort in put
    # recurse to find combinations
    # binary search 
    def combinationSum2(self, candidates, target):
        self.res = []
        candidates.sort()
        for i in xrange(len(candidates)):
            if(candidates[i] <= target/2):
                self.findComb(candidates, target - candidates[i], i + 1, [candidates[i]])
            elif(candidates[i] <= target):
                p = self.bSearch(candidates, target,i, len(candidates) - 1) 
                if(candidates[p] == target): self.res.append([target])
                break
        return self.res
                
    def findComb(self, candidates, target, b, l):
        for i in xrange(b, len(candidates)):
            if(candidates[i] <= target/2):
                t = list(l)
                t.append(candidates[i])
                self.findComb(candidates, target - candidates[i], i + 1, t)
            elif(candidates[i] <= target):
                p = self.bSearch(candidates, target,i, len(candidates) - 1) 
                if(candidates[p] == target): 
                    l.append(target)
                    if(l not in self.res): self.res.append(l)
                break
                
    def bSearch(self, can, target, b, e):
        if(b >= e): return b
        m = (b + e)/ 2
        if(can[m] == target): return m
        if(can[m] > target): return self.bSearch(can, target, b, m)
        else: return self.bSearch(can, target, m + 1, e)
# Accepted solution
s = Solution()
can = [10,1,2,7,6,1,5]
target = 8
print s.combinationSum2(can, target)