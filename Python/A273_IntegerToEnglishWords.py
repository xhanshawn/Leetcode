class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        d1 = ['Zero', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen','Sixteen','Seventeen', 'Eighteen', 'Nineteen']
        d10 = ['Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']
        units = ['1', '10', 'Hundred', '1Thousand', '10', 'Hundred', '1Million', '10', 'Hundred', 'Billion']
        units = ['Million', 'Thousand']
        if(num == 0): return d1[0]
        s = str(num)
        s = "0" * (10 - len(s)) + s
        res = d1[int(s[0])] + " " + "Billion " if(not s[0] == "0") else ""
        i = 1
        while(i < 8):
            n = int(s[i : i + 3])
            if(n == 0): 
                i += 3
                continue
            if(n // 100 > 0): res += d1[n // 100] + " Hundred "
            n = n % 100
            if(n < 20 and n > 0): res += d1[n] + " "
            elif(n >= 20): 
                if(n % 10 > 0): res += d10[n / 10 - 2] + " " + d1[n % 10] + " "
                else: res += d10[n / 10 - 2] + " "
            if(i // 3 < 2): res += units[i // 3] + " "
            i += 3
        if(res[-1] == " "): return res[: -1]
        else: return res
                

# ac, Annoying test cases