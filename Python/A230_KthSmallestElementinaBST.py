# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param {TreeNode} root
    # @param {integer} k
    # @return {integer}
    def kthSmallest(self, root, k):
        self.tra = []
        self.traverse(root)
        return self.tra[k - 1]
    def traverse(self, root):
        if(not root): return
        if(root.left): self.traverse(root.left)
        self.tra.append(root.val)
        if(root.right): self.traverse(root.right)
s = Solution()
r = TreeNode(5)
r.left = TreeNode(3)
r.left.right = TreeNode(4)
r.right = TreeNode(7)
r.right.left = TreeNode(6)
print s.kthSmallest(r, 3)
