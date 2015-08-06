class Solution:
    # @param {integer[][]} matrix
    # @param {integer} target
    # @return {boolean}
    def searchMatrix(self, matrix, target):
        if(len(matrix) == 0): return False
        if(len(matrix[0]) == 0): return False
        headers = []
        for l in matrix:
            headers.append(l[0])
        r = self.binarySearch(headers, target, 0, len(headers) - 1)
        c = self.binarySearch(matrix[r], target, 0, len(matrix[r]) - 1)
        has = (matrix[r][c] == target)
        if r > 0: r -= 1 
        c = self.binarySearch(matrix[r], target, 0, len(matrix[r]) - 1)
        has = has or (matrix[r][c] == target)
        return  has
        
    def binarySearch(self, A, target, b, e):
        if(b >= e): return e
        m = (b + e)/2
        if(target == A[m]): return m
        elif(target < A[m]): return self.binarySearch(A, target, b, m)
        else : return self.binarySearch(A, target, m + 1, e)
# accepted solution a little bit unexpected. in my opinion is not concise


s = Solution()
m = [[1,2,3],[4,5,6],[9,10,13]]
for x in range(0, 15) :
    print s.searchMatrix(m, x), x
print s.binarySearch([1,2,4], 3, 0, 2)
