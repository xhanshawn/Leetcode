# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if(p.val > q.val): return self.lowestCommonAncestor(root, q, p)
        self.p = p
        self.q = q
        res = None
        self.preorder = []
        self.traverse(root)
        for e in self.preorder:
            if((not res or res.val < e.val) and e.val <= q.val): res = e
            if(e.val == p.val): break
        return res
    def traverse(self, root):
        if(not root or not self.p and not self.q): return
        if(self.p and root.val == self.p.val): self.p = None
        if(self.q and root.val == self.q.val): self.q = None
        self.preorder.append(root)
        if(root.left): self.traverse(root.left)
        if(root.right): self.traverse(root.right)
# accepted solution






s = Solution()
r = TreeNode(5)
r.right = TreeNode(6)
r.left = TreeNode(3)
r.left.left = TreeNode(2)
r.left.left.left = TreeNode(1)
r.left.right = TreeNode(4)

print s.lowestCommonAncestor(r, TreeNode(1), TreeNode(4)).val



