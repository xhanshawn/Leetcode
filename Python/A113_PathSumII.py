class Solution:
    # @param {TreeNode} root
    # @param {integer} sum
    # @return {boolean}
    def pathSum(self, root, sum):
        self.target = sum
        return self.getSum(root, 0)

    def getSum(self, root, sum):
        paths = []
        if(root is not None) : 
            if (root.left is None and root.right is None) :
                if(root.val + sum == self.target): 
                    paths.append([root.val])
                    return paths
            else : 
                left = self.getSum(root.left, sum + root.val)
                right = self.getSum(root.right, sum + root.val)
                # print left, right
                if(len(left) > 0):
                    for l in left:
                        l.insert(0, root.val)
                        paths.append(l)
                if(len(right) > 0):
                    for r in right:
                        r.insert(0, root.val)
                        paths.append(r)
        return paths
        # elif (sum is self.target): self.has = True

# Accepted solution. At first I use top - bottom and record each node passed then failed by TLE
# So I changed to bottom-top only pass val when find targe sum


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
t1.left.left.left.left = TreeNode(1)
t1.left.left.left.left.right = TreeNode(1)


# t1.right.left = TreeNode(13)
# t1.right.right = TreeNode(4)
l = []
l.insert(0,[3])
print l
for ll in l:
    ll.insert(0,3)
print l
s = Solution()
result = s.pathSum(t1, -8)
print result
