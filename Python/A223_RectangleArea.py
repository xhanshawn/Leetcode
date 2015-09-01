class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        # abs(a - c) * abs(b - d) + abs(e - g) * abs(f - h) - abs(c - e) * abs(h - b)
        total = abs(A - C) * abs(B - D) + abs(E - G) * abs(F - H)
        d = 0
        # print total
        dx, dy = 0, 0
        if(E <= A): 
            if(G >= C):dx = abs(A - C)
            elif(G > A): dx = G - A
        else: 
            if(C >= G):dx = abs(E - G)
            elif(E <= C): dx = C - E
        if(F <= B):
            if(D <= H): dy = abs(B - D)
            elif(H >= B): dy = H - B
        else:
            if(H <= D): dy = abs(F - H)
            elif(F <= D): dy = D - F
        # print total
        return total - dx * dy
# Ac  solution
s = Solution()
print s.computeArea(-2, -2, 2, 2, -4, -4, -3, -3)