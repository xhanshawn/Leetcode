# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param {ListNode} node
    # @return {void} Do not return anything, modify node in-place instead.
    def deleteNode(self, node):
    	p = ListNode(0)
    	p.next = node
        while(p.next):
            if(p.next.next): 
            	p.next.val = p.next.next.val
                p = p.next
            else: p.next = None
p = ListNode(1)
p.next = ListNode(2)
p.next.next = ListNode(3)
p.next.next.next = ListNode(4)
s = Solution()
s.deleteNode(p.next.next)
while(p):
	print p.val
	p = p.next