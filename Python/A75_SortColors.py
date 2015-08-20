class Solution:
    # @param {integer[]} nums
    # @return {void} Do not return anything, modify nums in-place instead.
    def sortColors(self, nums):
        r = 0
        b = len(nums) - 1
        if(b <= 0): return
        w = r + 1
        if(nums[r] > nums[b]): self.swap(r, b, nums)
        if(nums[r] > nums[w]): self.swap(r, w, nums)
        while(w <= b):
            if(nums[w] == 1): w += 1
            elif(nums[w] == 0): 
                self.swap(w,r,nums)
                if(r < w): r += 1
                else: w += 1
            else:
                self.swap(w,b,nums)
                b -= 1
    def swap(self, i, j, nums):
        print i, j
        t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
    #Accepted solution match the requirements of follow up
s = Solution()
nums = [2,1,2]
# for i in range(100000):
#     nums.append(i%2)
s.sortColors(nums)
print nums
s.sortColors