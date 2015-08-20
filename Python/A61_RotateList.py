# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param {ListNode} head
    # @param {integer} k
    # @return {ListNode}
    def rotateRight(self, head, k):
        if(not head): return None
        if(k == 0): return head
        dummy = ListNode(0)
        q = head
        c = 0
        while(q and k > 0): 
            q = q.next
            k -= 1
            c += 1
        # print c, c
        if(not q): return self.rotateRight(head, k % c)
        p = ListNode(0)
        p = head
        while(q.next):
            q = q.next
            p = p.next
        dummy.next = p.next
        p.next = None
        q.next = head
        return dummy.next
# accepted


dummy = ListNode(0)
p = ListNode(1)
dummy.next = p
for i in range(1,5):
    p.next = ListNode(i + 1)
    p = p.next
p = dummy.next
while(p): 
    # print p.val
    p = p.next
s = Solution()
res = s.rotateRight(dummy.next,6)
c = 0
while(res and c < 10): 
    print res.val
    res = res.next
    c += 1
