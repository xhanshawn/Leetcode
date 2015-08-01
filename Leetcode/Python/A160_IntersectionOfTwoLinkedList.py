# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param two ListNodes
    # @return the intersected ListNode
    def getIntersectionNode(self, headA, headB):
        p = headA
        nodes = set()
        while(p is not None): 
            nodes.add(p)
            p = p.next
        p = headB
        while(p is not None):
            if(p in nodes): return p
            p = p.next
        return None
#accepted solution