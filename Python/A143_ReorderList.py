# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def reorderList(self, head):
    	if(not head): return
        dummy = ListNode(0)
        p, q = dummy, dummy
        dummy.next = head
        while(q):
            q = q.next
            if(q): q = q.next
            p = p.next
        sec = ListNode(0)
        # print p.val
        n = p.next
        p.next = None
        p = n
        # print p.val
        while(p):
        	t = p.next
        	p.next = sec.next
        	sec.next = p
        	p = t
        p, q = head, sec.next
        while(p and q):
        	# print p.val, q.val
        	t = q.next
        	n = p.next
        	q.next = n
        	p.next = q
        	q = t
        	p = n



s = Solution()
dummy = ListNode(0)
l = [1,2,3,4]
p = ListNode(0)
dummy.next = p
for e in l:
	p.next = ListNode(e)
	p = p.next

s.reorderList(dummy.next.next)
p = dummy.next.next
i = 0
while(p and i < 10):
	print p.val
	p = p.next
	i += 1

        