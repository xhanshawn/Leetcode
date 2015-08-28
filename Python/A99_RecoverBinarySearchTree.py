# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def recoverTree(self, root):
        self.cursor = None
        self.fst = None
        self.sec = None
        self.aft_fst = None
        self.traverse(root)
        t = self.fst.val
        if(not self.sec): self.sec = self.aft_fst
        self.fst.val = self.sec.val
        self.sec.val = t
    def traverse(self, root):
        if(not root or self.sec): return
        if(root.left): self.traverse(root.left)
        if(self.cursor == None): 
            self.cursor = root
        if(root.val < self.cursor.val):
            if(self.fst == None): 
                self.fst = self.cursor
                self.aft_fst = root
            elif(self.sec == None): self.sec = root
        self.cursor = root
        if(root.right): self.traverse(root.right)
# Accepted solution   :) happy day

s = Solution()
r = TreeNode(2)
r.left = TreeNode(3)
r.right = TreeNode(1)
# r.right.left = TreeNode(1)
s.recoverTree(r)
print r.val, r.right.val







                    