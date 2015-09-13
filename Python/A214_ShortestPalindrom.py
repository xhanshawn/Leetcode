class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        p, q = 0, len(s) - 1
        while(p < len(s) and q >= 0): 
            if(s[p] == s[q]): p, q = p + 1, q - 1
            else: q = q - 1
        if(p == len(s)): return s
        return s[p:][::-1] + self.shortestPalindrome(s[:p]) + s[p:]
        # magic solution...
        
    # def shortestPalindromeTLE(self, s):
    #     if(not s): return s
    #     minl = 2 * len(s)
    #     res = ""
    #     for i in xrange(len(s)):
    #         t = self.getPalin(i, s)
    #         if(len(t) < minl): res, minl = t, len(t)
    #     return res
    # def getPalin(self, i, s):
    #     if(i == 0): return self.reverse(s[1:]) + s
    #     if(i == len(s) - 1): return s + self.reverse(s[:-1]) 
    #     l = s[:i]
    #     r = s[i + 1:]
    #     lr = self.reverse(l)
    #     p = 0
    #     while(p < len(lr) and p < len(r) and lr[p] == r[p]): p += 1
    #     if(p == len(lr)): return self.reverse(r[p:]) + s
    #     elif(p == len(r)): return s + self.reverse(lr[:p + 1])
    #     else: return self.reverse(s[1:]) + s
        
    # def reverse(self, s):
    #     if(not s): return s
    #     res = ""
    #     for c in s: res = c + res
    #     return res
        
        
            
            