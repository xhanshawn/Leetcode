# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if(not root): return 0
        lh = self.getHeight(root.left)
        rh = self.getHeight(root.right)
        if(lh == rh): return 2**lh + self.countNodes(root.right)
        return 2**rh + self.countNodes(root.left)
    def getHeight(self, root):
        left = root
        h = 0
        while(left):
            left = left.left
            h += 1
        return h
# accept solution
s = Solution()
print s.countNodes(None)

