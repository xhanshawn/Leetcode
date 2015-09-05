class Queue(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.q = []
        self.stack = []

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        stack = self.stack
        q = self.q
        if(stack): stack.append(x)
        else:
            while(q):
                stack.append(q.pop())
            stack.append(x)

    def pop(self):
        """
        :rtype: nothing
        """
        stack = self.stack
        q = self.q
        if(not stack and not q): return None
        if(q): return q.pop()
        else:
            while(stack):
                q.append(stack.pop())
            q.pop()

    def peek(self):
        stack = self.stack
        q = self.q
        if(q): return q[-1]
        else:
            while(stack):
                q.append(stack.pop())
            return q[-1]

    def empty(self):
        return not self.stack and not self.q
# ac solution. problem is easy to pass and difficult to do online judge