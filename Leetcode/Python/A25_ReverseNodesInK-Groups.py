# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param {ListNode} head
    # @param {integer} k
    # @return {ListNode}
    def reverseKGroup(self, head, k):
        if(k <= 1): return head
        dummy = ListNode(0)
        dummy.next = head
        p = head
        has = False
        last = dummy
        while(p is not None):
            q = p
            t = k - 1
            while(q.next is not None and t > 0): 
                q = q.next
                t -= 1
            if(not has and t == 0): 
                dummy.next = q 
                has = True
            elif(last): 
                if(t == 0): last.next = q
                else : last.next = p
            temp = q.next
            if(t == 0): 
                last = self.reverse(p, k)
            p = temp
        if(not has): return head
        return dummy.next
    def reverse(self, head, k):
        r = head
        p = head.next
        r.next = None
        while(p is not None and k > 1):
            n = p.next
            p.next = r
            r = p
            p = n
            k -= 1
        return head

# accepted solution :) 
dummy = ListNode(0)
dummy.next = ListNode(1)
dummy.next.next = ListNode(2)
dummy.next.next.next = ListNode(3)
dummy.next.next.next.next = ListNode(4)
dummy.next.next.next.next.next = ListNode(5)

s = Solution()
r = s.reverseKGroup(dummy.next, 6)
# r = s.reverse(dummy.next, 2)

while (r is not None):
    print r.val
    r = r.next
