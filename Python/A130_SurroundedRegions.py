class Solution(object):
    # def solve2(self, board):
    #     if(len(board) == 0): return
    #     visited = [[False for x in xrange(len(board[0]))]for y in xrange(len(board))]
    #     for i in xrange(len(board)):
    #         if(not visited[i][0] and board[i][0] == 'O'): self.dfs(i, 0, board, visited)
    #         if(not visited[i][-1] and board[i][-1] == 'O'): self.dfs(i, len(board[0]) - 1, board, visited)
    #     for j in xrange(1, len(board[0]) - 1):
    #         if(not visited[0][j] and board[0][j] == 'O'): self.dfs(0, j, board, visited)
    #         if(not visited[-1][j] and board[-1][j] == 'O'): self.dfs(len(board) - 1, j, board, visited)
    #     for i in xrange(len(visited)):
    #         for j in xrange(len(visited[0])):
    #             if(board[i][j] == 'O' and not visited[i][j]): 
    #                 # board[i][j] = 'X'
    #                 board[i] = board[i][:j] + 'X' + board[i][j + 1:]

    # def dfs(self, i, j, board, visited):
    #     if(visited[i][j]): return
    #     visited[i][j] = True
    #     if(i + 1 < len(board) and board[i + 1][j] == 'O' and not visited[i + 1][j]): self.dfs(i + 1, j, board, visited)
    #     if(i > 0 and board[i - 1][j] == 'O' and not visited[i - 1][j]): self.dfs(i - 1, j, board, visited)
    #     if(j + 1 < len(board[0]) and board[i][j + 1] == 'O' and not visited[i][j + 1]): self.dfs(i, j + 1, board, visited)
    #     if(j > 0 and board[i][j - 1] == 'O' and not visited[i][j - 1]): self.dfs(i, j - 1, board, visited)
    # def solve3(self, board):
    #     if(len(board) == 0): return
    #     visited = [[False for x in xrange(len(board[0]))]for y in xrange(len(board))]
    #     stack = []
    #     for l in xrange(min(len(board)/2, len(board[0])/2)):
    #         for j in xrange(l, len(board[0]) - l):
    #             i = l
    #             stack.append((i, j))
    #             if(i == 0 or j == 0 or visited[i - 1][j] or visited[i][j - 1]): visited[i][j] |= (board[i][j] == 'O')
    #         for i in xrange(l, len(board) - l):
    #             j = len(board[0]) - l - 1
    #             stack.append((i, j))
    #             if(i == 0 or j == len(board[0]) - 1 or visited[i - 1][j] or visited[i][j + 1]): visited[i][j] |= (board[i][j] == 'O')
    #         for j in xrange(len(board[0]) - l - 1, l, -1):
    #             i = len(board) - l - 1
    #             stack.append((i, j))
    #             if(i == len(board) - 1 or j == len(board[0]) - 1 or visited[i + 1][j] or visited[i][j + 1]): visited[i][j] |= (board[i][j] == 'O')
    #         for i in xrange(len(board) - l - 1, l, -1):
    #             j = l
    #             stack.append((i, j))
    #             if(i == 0 or j == 0 or visited[i + 1][j] or visited[i][j - 1]): visited[i][j] |= (board[i][j] == 'O')

    #     # print visited
    #     while(len(stack) > 1):
    #         cur = stack.pop()
    #         top = stack[-1]
    #         visited[cur[0]][cur[1]] |= visited[top[0]][top[1]]
    #     for i in xrange(len(visited)):
    #         for j in xrange(len(visited[0])):
    #             if(board[i][j] == 'O' and not visited[i][j]): 
    #                 # board[i][j] = 'X'
    #                 board[i] = board[i][:j] + 'X' + board[i][j + 1:]
    def solve(self, board):
        if(len(board) == 0): return
        visited = [[False for x in xrange(len(board[0]))]for y in xrange(len(board))]
        for i in xrange(len(board)):
            if(not visited[i][0] and board[i][0] == 'O'): self.bfs(i, 0, board, visited)
            if(not visited[i][-1] and board[i][-1] == 'O'): self.bfs(i, len(board[0]) - 1, board, visited)
        for j in xrange(1, len(board[0]) - 1):
            if(not visited[0][j] and board[0][j] == 'O'): self.bfs(0, j, board, visited)
            if(not visited[-1][j] and board[-1][j] == 'O'): self.bfs(len(board) - 1, j, board, visited)
        for i in xrange(len(visited)):
            for j in xrange(len(visited[0])):
                if(board[i][j] == 'O' and not visited[i][j]): 
                    # board[i][j] = 'X'
                    # print i, j, board[i][j]
                    board[i] = board[i][:j] + 'X' + board[i][j + 1:]
    def bfs(self, x, y, board, visited):
        que = [(x, y)]
        while(len(que) > 0):
            p = que.pop(0)
            i, j = p[0], p[1]
            print p
            visited[i][j] = True
            if(i + 1 < len(board) and board[i + 1][j] == 'O' and not visited[i + 1][j]): 
                visited[i + 1][j] = True
                que.append((i + 1, j))
            if(i > 0 and board[i - 1][j] == 'O' and not visited[i - 1][j]): 
                visited[i - 1][j] = True
                que.append((i - 1, j))
            if(j + 1 < len(board[0]) and board[i][j + 1] == 'O' and not visited[i][j + 1]): 
                visited[i][j + 1] = True
                que.append((i, j + 1))
            if(j > 0 and board[i][j - 1] == 'O' and not visited[i][j - 1]): 
                visited[i][j - 1] = True
                que.append((i, j - 1))
# BFS is the accepted solution

s = Solution()
# board = [['X','X','X','X'], ['X','O','O','X'], ['X','X','O','X'], ['X','O','X','X']]
board = ['XXXX', 'X00X', 'XX0X', 'X0XX']
board = ["XXX","XOX","XXX"]
board = ["OXXOX",
         "XOOXO",
         "XOXOX",
         "OXOOO",
         "XXOXO"]
board = ["XOOOOOOOOOOOOOOOOOOO","OXOOOOXOOOOOOOOOOOXX","OOOOOOOOXOOOOOOOOOOX","OOXOOOOOOOOOOOOOOOXO","OOOOOXOOOOXOOOOOXOOX","XOOOXOOOOOXOXOXOXOXO","OOOOXOOXOOOOOXOOXOOO","XOOOXXXOXOOOOXXOXOOO","OOOOOXXXXOOOOXOOXOOO","XOOOOXOOOOOOXXOOXOOX","OOOOOOOOOOXOOXOOOXOX","OOOOXOXOOXXOOOOOXOOO","XXOOOOOXOOOOOOOOOOOO","OXOXOOOXOXOOOXOXOXOO","OOXOOOOOOOXOOOOOXOXO","XXOOOOOOOOXOXXOOOXOO","OOXOOOOOOOXOOXOXOXOO","OOOXOOOOOXXXOOXOOOXO","OOOOOOOOOOOOOOOOOOOO","XOOOOXOOOXXOOXOXOXOO"]
s.solve(board)
print board

