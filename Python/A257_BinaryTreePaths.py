# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        self.res = []
        self.traverse(root,"")
        return self.res
        
    def traverse(self, root, path):
        if(not root): return
        if(path == ""): t = str(root.val)
        else: t = path + "->" + str(root.val)
        if(not root.left and not root.right): 
            self.res.append(t)
            return
        self.traverse(root.left, t)
        self.traverse(root.right, t)
            