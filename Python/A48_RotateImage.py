class Solution:
    # @param {integer[][]} matrix
    # @return {void} Do not return anything, modify matrix in-place instead.
    def rotate(self, matrix):
        d = len(matrix) - 1
        for i in xrange((len(matrix) + 1)/2):
            for j in xrange(len(matrix)/2):
                t = matrix[i][j]
                matrix[i][j] = matrix[d - j][i]
                matrix[d - j][i] = matrix[d - i][d - j]
                matrix[d - i][d - j] = matrix[j][d - i]
                matrix[j][d - i] = t
# accepted solution math problem in my opinion
s = Solution()
dim = 5
matrix = [[i * dim + j  for j in xrange(dim)]for i in xrange(dim)]
print matrix
s.rotate(matrix)
print matrix