class Solution:
    # @param {string} a
    # @param {string} b
    # @return {string}
    def addBinary(self, a, b):
        if(len(a) < len(b)): return self.addBinary(b, a)
        diff = len(a) - len(b)
        offset = ""
        for _ in range(diff): offset += "0"
        b = offset + b
        carry = 0
        result = ""
        for p in range(0, len(a)): 
            sum = int(a[len(a) - 1 - p]) + int(b[len(a) - 1 - p]) + carry
            carry = sum / 2
            result = str(sum % 2) + result
        if(carry > 0): result = "1" + result
        return result

#Accepted solution 
s = Solution()
print s.addBinary("11111", "1")