class Solution(object):
    def addDigits2(self, num):
        """
        :type num: int
        :rtype: int
        """
        if(num < 10): return num
        res = 0
        for e in str(num): res += int(e)
        return self.addDigits(res)
    def addDigits(self, num):
        return 9 if num % 9 == 0 and not num == 0 else num % 9