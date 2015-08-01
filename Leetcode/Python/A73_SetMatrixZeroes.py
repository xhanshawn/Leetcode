class Solution:
    # @param {integer[][]} matrix
    # @return {void} Do not return anything, modify matrix in-place instead.
    def setZeroes(self, matrix):
        if(not matrix or not matrix[0]): return
        r0 = [0]* len(matrix[0])
        row = set()
        col = set()
        for r in range(len(matrix)):
            for c in range(len(matrix[0])):
                if(matrix[r][c] == 0):
                    row.add(r)
                    col.add(c)
        for r in row:
            matrix.remove(matrix[r])
            matrix.insert(r, r0)
        for c in col:
            for i in range(len(matrix)): matrix[i][c] = 0


    def setZeroes1(self, matrix):
        if(not matrix or not matrix[0]): return
        r0 = [0]* len(matrix[0])
        first_r = -1
        first_c = -1
        for r in range(len(matrix)):
            for c in range(len(matrix[0])):
                if(matrix[r][c] == 0):
                    if(first_c < 0): 
                        first_c = c
                        first_r = r
                    matrix[first_r][c] = 0
                    matrix[r][first_c] = 0
        if(first_r < 0): return
        for r in range(len(matrix)):
            if(matrix[r][first_c] == 0 and not r == first_r):
                matrix[r] = r0
        for c in range(len(matrix[0])):
            if(matrix[first_r][c] == 0):
                for i in range(len(matrix)): matrix[i][c] = 0
        matrix[first_r] = r0

# all accepted solutions, second is better cause less space
s = Solution()
# m = [[1,1,1,0],
#     [0,1,1,1],
#     [0,0,1,1],
#     [0,0,0,1]]
m = [[1,6],[1,0],[3,2],[3,5],[2,2],[4,7],[9,1],[3,2],[0,6]]

s.setZeroes1(m)
print m