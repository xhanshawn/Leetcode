# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {integer[][]}
    def levelOrder(self, root):
        self.res = []
        self.traverse(root, 0)
        return self.res
    def traverse(self, root, h):
        if(not root): return
        if(root.left): self.traverse(root.left, h + 1)
        if(len(self.res) > h): self.res[h].append(root.val)
        else: 
            while(len(self.res) <= h): self.res.append([])
            self.res[h].append(root.val)
        if(root.right): self.traverse(root.right, h + 1)
#Accepted Solution