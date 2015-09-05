class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        if(not board): return []
        trie = {}
        for w in words:
            t = trie
            for c in w:
                if(c not in t): t[c] = {}
                t = t[c]
            t['end'] = w
        # print trie
        self.res = []
        self.visited = set()
        for i in xrange(len(board)):
            for j in xrange(len(board[0])):
                self.dfs(board,(i, j), trie)
        return list(set(self.res))
        
    def dfs(self, board, pos, t):
        # print t
        if('end' in t): self.res.append(t['end'])
        i, j = pos[0], pos[1]
        if(pos in self.visited or i<0 or i>=len(board) or j<0 or j>=len(board[0]) or board[i][j] not in t ): return
        self.visited.add(pos)
        if(not (i - 1, j) in self.visited): self.dfs(board, (i - 1, j), t[board[i][j]])
        if(not (i + 1, j) in self.visited): self.dfs(board, (i + 1, j), t[board[i][j]])
        if(not (i, j - 1) in self.visited): self.dfs(board, (i, j - 1), t[board[i][j]])
        if(not (i, j + 1) in self.visited): self.dfs(board, (i, j + 1), t[board[i][j]])
        self.visited.remove(pos)
# accepted solution

s = Solution()
board = [
'oaan',
'etae',
'ihkr',
'iflv'
]
words = ['eat', 'oath']
board = ['ab']
words = ['ba']
print s.findWords(board,words)




