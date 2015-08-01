class Solution:
    # @param {integer[][]} matrix
    # @param {integer} target
    # @return {boolean}
    def searchMatrix(self, matrix, target):
        if(len(matrix) == 0): return False
        c_len = len(matrix[0])
        if(c_len == 0): return False
        rs = []
        for l in matrix:
            if(l[0] <= target and l[c_len - 1] >= target): rs.append(l)
        has = False
        for row in rs:
            p = self.binarySearch(row, target, 0, c_len - 1)
            has = has or (row[p] == target)
        return  has
        
    def binarySearch(self, A, target, b, e):
        if(b >= e): return e
        m = (b + e)/2
        if(target == A[m]): return m
        elif(target < A[m]): return self.binarySearch(A, target, b, m)
        else : return self.binarySearch(A, target, m + 1, e)
# accepted solution 
s = Solution()
# m = [[1,2,3],[4,5,6],[9,10,13]]
m = [[5]]
for x in range(0, 15) :
    print s.searchMatrix(m, x), x
print s.binarySearch([1,2,4], 3, 0, 2)