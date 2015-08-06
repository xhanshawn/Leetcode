# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param {ListNode} head
    # @param {integer} val
    # @return {ListNode}
    def removeElements(self, head, val):
        dummy = ListNode(0)
        dummy.next = head
        p = dummy
        while(p.next):
            if(p.next.val == val):
                p.next = p.next.next
            else: p = p.next
        return dummy.next
s = Solution()
head = ListNode(1)
head.next = ListNode(1)
head.next.next = ListNode(3)
head.next.next.next = ListNode(2)

p = s.removeElements(head, 1)
while(p):
    print p.val
    p = p.next