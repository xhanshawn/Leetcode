# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSameTree(self, p, q):
        self.res = True
        self.traverse(p, q)
        return self.res
    def traverse(self, p, q):
        if(p and not q or not p and q):
            self.res = False
            return
        if(not p and not q): return
        if(not p.val == q.val): self.res = False
        self.traverse(p.left, q.left)
        self.traverse(p.right, q.right)
        
# AC solution. 