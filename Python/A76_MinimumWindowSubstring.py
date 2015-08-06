class Solution:
    # @param {string} s
    # @param {string} t
    # @return {string}
    def minWindow(self, s, t):
        if(len(t) == 1):
            if(t in s): return t
            else: return ""
        ds = dict()
        dt = dict()
        result = ""
        for c in t:
            dt[c] = dt.get(c, 0) + 1
        l = 0
        p = 0
        q = 0
        min_l = len(s) + 1
        while(q < len(s)):
            c = s[q]
            if(l < len(t)):
                if(c in dt):
                    ds[c] = ds.get(c, 0) + 1
                    if(ds[c] <= dt[c]):
                        l += 1
                q += 1
            while(l == len(t)):
                if(q - p < min_l): 
                    result = s[p : q]
                    min_l = q - p
                if(s[p] in dt):
                    ds[s[p]] -= 1
                    if(ds[s[p]] < dt[s[p]]): l -= 1
                p += 1
                
        return result

#accepted solution find a correct window first then move left pointer and then move right pointer to 
#keep all characters of t in window
s = Solution()
print s.minWindow("ADOBECODEBANC", "ABC")
print s.minWindow("cabwefgewcwaefgcf", "cae")