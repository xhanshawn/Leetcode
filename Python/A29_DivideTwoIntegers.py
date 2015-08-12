class Solution:
    # @param {integer} dividend
    # @param {integer} divisor
    # @return {integer}
    def divide(self, dividend, divisor):
        z_sign = dividend > 0
        d_sign = divisor > 0
        z = str(abs(dividend))
        d = str(abs(divisor))
        lz = len(z)
        ld = len(d)
        if(lz < ld): return 0
        d += "0" * lz
        z += "0" * ld
        q = ""
        for i in xrange(lz - ld + 1):
            inz = int(z[:lz])
            ind = int(d[:lz])
            if(ind == 0): return 0
            print inz, ind
            print z, d, "str"
            r = 0
            while(inz - ind >= 0 and inz > 0): 
                inz -= ind
                r += 1
            print r, "r"
            q += str(r)
            d = "0" + d[:-1]
            
            z = str(inz) + z[lz:]
            z = "0" * (lz + ld - len(z)) + z
            # z = z[1:]
        if(z_sign == d_sign): 
            if(int(q) >= 2147483648): return 2147483647
            return int(q)
        else: 
            return -int(q)
# Accepted solution...
s = Solution()
print s.divide(-1021989372, -82778243)
# for x in xrange(1,100):
#     res = s.divide(-100, x)
#     if(not res == -100//x): print res, -100//x, x
