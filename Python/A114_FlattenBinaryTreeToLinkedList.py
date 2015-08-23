# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def flatten(self, root):
        dummy = TreeNode(0)
        self.p = dummy
        self.traverse(root)
    def traverse(self, root):
        if(not root): return
        # print root.val
        t = root.right
        self.p.right = root
        ########## here is a point.  without assign left to None it show TLE
        ########## I reckon this is because the test do traversal as well
        self.p.left = None
        ##########
        self.p = self.p.right
        if(root.left): self.traverse(root.left)
        if(t): self.traverse(t)

s = Solution()
r = TreeNode(1)
r.left = TreeNode(2)
r.right = TreeNode(5)
r.left.left = TreeNode(3)
r.left.right = TreeNode(4)
r.right.right = TreeNode(6)

res = s.flatten(r)
while(res):
    print res.val
    if(res.left): print res.left.val
    res = res.right