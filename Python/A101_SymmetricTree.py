# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    # def isSymmetric(self, root):
    #     if(not root): return False
    #     self.l = []
    #     self.traverse(root.right)
    #     r = list(self.l)
    #     self.l = []
    #     self.traverse(root.left)
    #     if(not len(r) == len(self.l)): return False
    #     print r, self.l
    #     for i in xrange(len(self.l)):
    #         if(not self.l[i] == r[len(r) - 1 - i]): 
    #             if(self.l[i] == 'l' and r[len(r) - 1 - i] == 'r' or self.l[i] == 'r' and r[len(r) - 1 - i] == 'l'): continue
    #             return False
    #     return True
    # def traverse(self, root):
    #     if(not root): return
    #     if(root.left): self.traverse(root.left)
    #     elif(root.right): self.l.append('l')
    #     self.l.append(root.val)
    #     if(root.right): self.traverse(root.right)
    #     elif(root.left): self.l.append('r')
    def isSymmetric(self, root):
        if(not root): return True
        self.r = {}
        self.traverse(root.left, 1)
        l = dict(self.r)
        self.r = {}
        self.traverse(root.right, 1)
        if(not len(l) == len(self.r)): return False
        for e in l:
            if(e not in self.r): return False
            right = self.r[e]
            left = l[e]
            print left, right, e
            if(not len(left) == len(right)): return False
            for i in xrange(len(left)):
                if(not left[i] == right[len(left) - 1 - i]): return False
        return True


    def traverse(self, root, lv):
        if(not root): return
        if(root.left): self.traverse(root.left, lv + 1)
        else:
            self.r[lv + 1] = self.r.get(lv + 1, [])
            self.r[lv + 1].append('n')
        self.r[lv] = self.r.get(lv, [])
        self.r[lv].append(root.val)
        if(root.right): self.traverse(root.right, lv + 1)
        else:
            self.r[lv + 1] = self.r.get(lv + 1, [])
            self.r[lv + 1].append('n')

# Accepted solution      
        
s = Solution()
r = TreeNode(1)
r.left = TreeNode(2)
r.right = TreeNode(2)
r.left.left = TreeNode(3)
r.left.right = TreeNode(4)
r.right.left = TreeNode(4)
r.right.right = TreeNode(3)
# r.left = TreeNode(2)
# r.right = TreeNode(3)
# r.left.left = TreeNode(3)
# r.right.left = TreeNode(2)
print s.isSymmetric(r)