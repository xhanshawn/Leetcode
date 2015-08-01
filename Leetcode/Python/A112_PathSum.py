class Solution:
    # @param {TreeNode} root
    # @param {integer} sum
    # @return {boolean}
    def hasPathSum(self, root, sum):
        self.target = sum
        self.has = False
        self.getSum(root, 0)
        return self.has and (root is not None)

    def getSum(self, root, sum):
        if(root is not None) : 
            if (root.left is None and root.right is None) :
                self.has = self.has or ((sum + root.val) == self.target)
            left = self.getSum(root.left, sum + root.val)
            right = self.getSum(root.right, sum + root.val)
        # elif (sum is self.target): self.has = True

# Accepted solution. Should care about differences between 'is' and '==' for integer in python


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

t1 = TreeNode(-3)
t1.left = TreeNode(-9)
# t1.right = TreeNode(-8)
t1.left.left = TreeNode(-5)
t1.left.left.left = TreeNode(7)
t1.left.left.left.right = TreeNode(2)


# t1.right.left = TreeNode(13)
# t1.right.right = TreeNode(4)

s = Solution()
result = s.hasPathSum(t1, -8)
if(result) : print 'ok'
else : print 'fuck'
