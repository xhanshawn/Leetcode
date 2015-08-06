import copy
class Solution:
    # @param {character[][]} board
    # @return {void} Do not return anything, modify board in-place instead.
    # def solveSudoku(self, board):
    #     ans = []
    #     for r in range(0, 9):
    #         row = []
    #         for c in range(0, 9):
    #             row.append([i for i in range(1, 10)])
    #         ans.append(row)
        
    #     not_solved = True
    #     i = 0
    #     # print ans
    #     # print board
    #     self.row_set = []
    #     self.col_set = []
    #     self.blk_set = []

    #     while(not_solved and i < 100):
    #         # print ans
    #         self.initSolve(ans, board)
    #         self.insert(ans, board)
    #         for row in board:
    #             not_solved = ('.' in row)
    #         i += 1
    #     self.solve(ans, board, self.row_set, self.col_set, self.blk_set )
    #     print ans
    # def initSolve(self, ans, board):
    #     for r in range(0, 9):
    #         row_s = []
    #         for c in range(0, 9):
    #             if (not board[r][c] == '.'): 
    #                 if(int(board[r][c]) in row_s): return False
    #                 else: row_s.append(int(board[r][c]))
    #                 ans[r][c] = []
    #         for has in row_s:
    #             for sol in ans[r]:
    #                 if(has in sol): 
    #                     sol.remove(has)
    #         self.row_set.append(row_s)

    #     for c in range(0, 9):
    #         col_s = []
    #         for r in range(0, 9):
    #             if(not board[r][c] == '.'): 
    #                 if(int(board[r][c]) in col_s): return False
    #                 else: col_s.append(int(board[r][c]))
    #         for has in col_s:
    #             for r in range(0, 9):
    #                 if(has in ans[r][c]): ans[r][c].remove(has)
    #         self.col_set.append(col_s)
    #     for i in range(0, 3):
    #         for j in range(0, 3):
    #             blk_s = []
    #             for r in range(i * 3, i * 3 + 3):
    #                 for c in range(j * 3, j * 3 + 3):
    #                     if(not board[r][c] == '.'): 
    #                         if(int(board[r][c]) in blk_s): return False
    #                         else: blk_s.append(int(board[r][c]))
    #             for has in blk_s:
    #                 for p in range(i * 3, i * 3 + 3):
    #                     for q in range(j * 3, j * 3 + 3):
    #                         if(has in ans[p][q]): ans[p][q].remove(has)
    #             self.blk_set.append(blk_s)
    #     return True
    # def insert(self, ans, board):
    #     for r in range(0, 9):
    #         temp = ""
    #         for c in range(0, 9):
    #             if(not board[r][c] == '.'):
    #                 temp += board[r][c]
    #             elif(len(ans[r][c]) == 1): 
    #                 temp += str(ans[r][c][0])
    #             else: 
    #                 temp += board[r][c]
    #         board[r] = temp
    #     return True
    # def solve(self, ans, board, row_set, col_set, blk_set):
    #     for r in range(0, 9):
    #         for c in range(0, 9):
    #             if(len(ans[r][c]) == 0): continue
    #             else:
    #                 while(len(ans[r][c]) > 0):
    #                     e = ans[r][c][0]
    #                     print e
    #                     if(e in row_set[r] or e in col_set[c] or e in blk_set[r / 3 * 3 + c / 3]):
    #                         print 'F.........', e
    #                         return False
    #                     # print ans, '\n'
    #                     temp = copy.deepcopy(ans)
    #                     temp_b = copy.deepcopy(board)
    #                     temp_rs = copy.deepcopy(row_set)
    #                     temp_cs = copy.deepcopy(col_set)
    #                     temp_bs = copy.deepcopy(blk_set)
    #                     # self.insert(temp, temp_b)
    #                     temp_rs[r].append(e)
    #                     temp_cs[c].append(e)
    #                     temp_bs[r/3 * 3 + c / 3].append(e)
    #                     # self.remove(temp, temp_b, temp_rs, temp_cs, temp_bs)
    #                     temp[r][c] = []
    #                     self.insert(temp, temp_b)
    #                     # print temp, '\n'
    #                     if(self.solve(temp, temp_b, temp_rs, temp_cs, temp_bs)): 
    #                         # print temp, '\n'
    #                         print "Yes........"
    #                         row_set = temp_rs 
    #                         col_set = temp_cs
    #                         blk_set = temp_bs
    #                         board = temp_b
    #                         ans = temp
    #                         break
    #                     else:
    #                         print ans[r][c], "h"
    #                         ans[r][c].remove(e)
    #                         print ans[r][c], "i"
    #     return True
    # def remove(self, ans, board, row_set, col_set, blk_set):
    #     for r in range(0, 9):
    #         for c in range(0, 9):
    #             for a in ans[r][c]:
    #                 if(a in row_set[r] or a in col_set[c] or a in blk_set[r / 3 * 3 + c / 3]):
    #                     ans[r][c].remove(a)

        # for r in range(0, 9):
        #     s = dict()
        #     for c in range(0, 9):
        #         for e in ans[r][c]: s[e] = s.get(e, []) + [c]
        #     for key in s:
        #         if(len(s[key]) == 1): 
        #             ans[r][s[key][0]] = [key]
        # for c in range(0, 9):
        #     s = dict()
        #     for r in range(0, 9):
        #         for e in ans[r][c]: s[e] = s.get(e, []) + [r]
        #     for key in s:
        #         if(len(s[key]) == 1): 
        #             ans[s[key][0]][c] = [key]
        # for i in range(0, 3):
        #     for j in range(0, 3):
        #         s = dict()
        #         for p in range(i * 3, i * 3 + 3):
        #             for q in range(j * 3, j * 3 + 3):
        #                 for e in ans[p][q]: s[e] = s.get(e, []) + [p, q]
        #         for key in s:
        #             if(len(s[key]) == 2): 
        #                 ans[s[key][0]][s[key][1]] = [key]
    

    # tusizi's solution
    def solveSudoku(self, board):
        result = self.dfs(board)
        for n, row in enumerate(result):
            board[n] = ''.join(row)

    def dfs(self, board):
        stk = [board]
        i = 0
        while (stk and i < 100) :
            b = stk.pop()
            result = self.fill_board(b)
            if (result == 'complete'):
                return b
            for row in result:
                stk.append(row)
            i += 1
    def fill_board(self, board):
        digits = set('123456789')
        ans, guess = {}, []
        for i in range(9):
            for j in range(9):
                if (board[i][j] == '.'):
                    blk = {board[i//3 * 3 + x][j//3 * 3 + y] for x in range(3) for y in range(3)}
                    row = {board[i][x] for x in range(9)}
                    col = {board[y][j] for y in range(9)}
                    rem = digits.difference(blk, row, col)
                    if (len(rem) == 1):
                        r_list = list(board[i])
                        r_list[j] = rem.pop()
                        board[i] = ''.join(r_list)
                        return self.fill_board(board)
                    elif (len(rem) == 0): return ''
                    else: ans[(i, j)] = rem
        if(not ans): 
            return 'complete'
        # x, y is the ans with less possible result length
        x, y = min(ans, key = lambda k : len(ans[k]))
        for a in ans[(x, y)]:
            temp_b = copy.deepcopy(board)
            r_list = list(temp_b[x])
            r_list[y] = a
            temp_b[x] = ''.join(r_list)
            guess.append(temp_b)
        return guess
    # def solveSudoku(self, board):
    #     res = self.dfs(board)
    #     for n, row in enumerate(res):
    #         board[n] = ''.join(row)

    # def dfs(self, board):
    #     stack = [board]
    #     while stack:
    #         s = stack.pop()
    #         result = self.fill_board(s)
    #         if result == 'complete':
    #             return s
    #         for r in result:
    #             stack.append(r)

    # def fill_board(self, board):
    #     digits = set('123456789')
    #     choice, best = {}, []
    #     for j in range(9):
    #         for i in range(9):
    #             if board[j][i] == '.':
    #                 square = {board[j//3*3+y][i//3*3+x]
    #                       for y in range(3) for x in range(3)}
    #                 row = {board[j][x] for x in range(9)}
    #                 col = {board[y][i] for y in range(9)}
    #                 rest = digits.difference(square, row, col)
    #                 if len(rest) == 1:
    #                     return self.fill_board(board)
    #                 elif len(rest) == 0:
    #                     return ''
    #                 else:
    #                     choice[(j, i)] = rest
    #     if not choice:
    #         return 'complete'
    #     y, x = min(choice, key=lambda k: len(choice[k]))
    #     for n in choice[(y, x)]:
    #         b = copy.deepcopy(board)
    #         b[y][x] = n
    #         best.append(b)
    #     return best

s = Solution()
b = ["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
s.solveSudoku(b)
print b