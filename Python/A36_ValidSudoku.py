class Solution:
    # @param {character[][]} board
    # @return {boolean}
    def isValidSudoku(self, board):
        result = True
        for r in board:
            result &= self.check(r)
            print r
        for c in range(0, 9):
            temp = []
            for r in range(0, 9):
                temp.append(board[r][c])
            result &= self.check(temp)
        for i in range(0, 3):
            for j in range(0, 3):
                temp = []
                for r in range(i * 3, i * 3 + 3):
                    temp.extend(board[r][3 * j: 3 * j + 3])
                result &= self.check(temp)
                print temp
        return result
        
        
    def check(self, l):
        s = set()
        for c in l:
            if(c == '.'): continue
            if(c in s): return False
            s.add(c)
        return True
# accepted solution
s = Solution()
sudu = [".87654321","2........","3........","4........","5........","6........","7........","8........","9........"]
print s.isValidSudoku(sudu)