class Solution:
    # @param {string} input
    # @return {integer[]}
    # def diffWaysToCompute(self, input):
    #     if(input.isdigit()): return [int(input)]
    #     os1 = self.separate(input, True)
    #     if(os1[0].isdigit() and os1[2].isdigit()):
    #         return [self.compute(os1[0], os1[1], os1[2])]
    #     result = []
    #     print os1
    #     result.extend(self.computeAll([os1[0]], os1[1], self.diffWaysToCompute(os1[2])))
    #     os2 = self.separate(input, False)
    #     result.extend(self.computeAll(self.diffWaysToCompute(os2[0]), os2[1], [os2[2]]))
    #     mid = self.separate(self.separate(os1[2], False)[0], True)
    #     # print s, "m", input
    #     if(len(mid) > 0 and mid[0].isdigit() and mid[2].isdigit()):
    #         f = self.compute(os1[0], os1[1], mid[0])
    #         s = self.compute(mid[2], os2[1], os2[2])
    #         result.append(self.compute(f, mid[1], s))
    #     elif(len(mid) > 0):
    #         f = self.compute(os1[0], os1[1], mid[0])
    #         ss = self.separate(mid[2], False)
    #         s = self.compute(ss[2], os1[1], os2[2])
    #         f = self.computeAll([f], mid[1], self.diffWaysToCompute(ss[0]))
    #         result.extend(self.computeAll(f, ss[1], [s]))  
    #     return result
    
    
    # def separate(self, s, first):
    #     result = []
    #     if(s.isdigit()): return result
    #     if(first):
    #         p = 0
    #         while(p < len(s) and s[p].isdigit()): p += 1
    #         result.append(s[:p])
    #         if(p < len(s)):
    #             result.append(s[p])
    #             result.append(s[p + 1:])
    #     else:
    #         p = len(s) - 1
    #         while(p >= 0 and s[p].isdigit()): p -= 1
    #         result.append(s[:p])
    #         if(p < len(s)):
    #             result.append(s[p])
    #             result.append(s[p + 1:])
    #     return result


    def diffWaysToCompute(self, input):
        ops = self.convert(input)
        return self.getWays(ops)
    def getWays(self, ops):
        if(len(ops) == 0): return []
        if(len(ops) == 1): return [int(ops[0])]
        if(len(ops) == 3): return [self.compute(ops[0], ops[1], ops[2])]
        i = 1
        result = []
        while(i < len(ops) - 1):
            # print ops[:i], ops[i], ops[i + 1:]
            result.extend(self.computeAll(self.getWays(ops[:i]), ops[i], self.getWays(ops[i + 1:])))
            i += 2
        return result
    def convert(self, s):
        result = []
        p = 0
        while(p < len(s)):
            q = p
            while(q < len(s) and s[q].isdigit()): q += 1
            result.append(int(s[p : q]))
            if(q < len(s)): result.append(s[q])
            p = q + 1
        return result
    def compute(self, o1, op, o2):
        d = {
            "+": (o1 + o2),
            "-": (o1 - o2),
            "*": (o1 * o2),
            }
        return d[op]
    def computeAll(self, o1s, op, o2s):
        result = []
        for o1 in o1s:
            for o2 in o2s:
                result.append(self.compute(o1, op, o2))
        return result
# accepted solution
s = Solution()
# print s.convert("1")
print s.diffWaysToCompute("15-7*6+24")
