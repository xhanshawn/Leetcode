
class Solution(object):
    def largestNumber(self, nums):
        for i in xrange(len(nums)):
            nums[i] = str(nums[i])
        nums.sort(cmp=lambda x, y: 1 if x + y < y + x else -1) # reverse sort by alphabet also avoid following test case. 
        # key= has 1 arguments. cmp= has two arguments
        return str(eval(''.join(nums)))
        
# ac


s = Solution()
nums = ['121', '12']
nums = ['0', '0']
nums.sort(reverse = True)
# nums.reverse()
st = str(nums)
print s.largestNumber(nums)
