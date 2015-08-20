class Solution:
    # @param {character[][]} matrix
    # @return {integer}
    def maximalRectangle(self, matrix):
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
                    if(len(stack) > 0): res = max(h * (i - stack[-1] - 1), res)
                    else: res = max(h * i, res)
                stack.append(i)
        return res
# Accepted solution based on histogram
s = Solution()
matrix = ["000011101","001111101","000111110"]
matrix = ["10"]
print s.maximalRectangle(matrix)
