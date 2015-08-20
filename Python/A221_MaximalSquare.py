class Solution:
    # @param {character[][]} matrix
    # @return {integer}
    def maximalSquare(self, matrix):
        if(len(matrix) == 0): return 0
        height = []
        for line in matrix:
            h = []
            if(len(height) == 0):
                for e in line: h.append(int(e))
            else:
                for i in xrange(len(line)): 
                    if(line[i] == '0'): h.append(0)
                    else: h.append(int(line[i]) + int(height[-1][i]))
            height.append(h)     
        # print height
        res = 0
        for line in height:
            stack = [0]
            for i in xrange(1, len(line) + 1):
                while(len(stack) > 0 and (i == len(line) or line[i] < line[stack[-1]])):
                    h = line[stack.pop()]
                    if(len(stack) > 0):
                        w = min(h, i - stack[-1] - 1)
                        res = max(w * w, res)
                    else: 
                        w = min(h, i)
                        res = max(w * w, res)
                stack.append(i)
        return res
# Accepted solution