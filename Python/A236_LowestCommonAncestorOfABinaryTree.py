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
        self.post = []
        self.postOrder(root)
        i = 0
        while(i < len(self.post) and not (self.post[i] == p or self.post[i] == q)): i += 1
        if(i == len(self.post)): return None
        if(self.post[i] == q): 
            t = q
            q = p
            p = t
        self.pv = p
        self.path = None
        self.getAncestor(root, set())
        getQ = False
        while(i < len(self.post)):
            if(self.post[i] == q): getQ = True
            if(getQ and self.post[i] in self.path): return self.post[i]
            i += 1

    def getAncestor(self, root, s):
        if(not root or self.path): return
        if(root == self.pv): 
            s.add(root)
            self.path = s
            return
        s.add(root)
        self.getAncestor(root.left, s)
        self.getAncestor(root.right, s)
    def postOrder(self, root):
        if(not root): return
        self.postOrder(root.left)
        self.postOrder(root.right)
        self.post.append(root)

# Accepted but i don't think it is concise.



s = Solution()

r = TreeNode(3)
r.left = TreeNode(5)
r.left.left = TreeNode(6)
r.left.right = TreeNode(2)
r.left.right.left = TreeNode(7)
r.left.right.right = TreeNode(4)
r.right = TreeNode(1)
r.right.left = TreeNode(0)
r.right.right = TreeNode(8)

print s.lowestCommonAncestor(r, r, r.right.right).val





