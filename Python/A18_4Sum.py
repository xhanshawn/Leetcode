class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[][]}
    def fourSum(self, nums, target):
        if(len(nums) < 4): return []
        nums.sort()
        res = []
        p, q = 0, 1
        print nums
        while(p < len(nums) - 3):
            q = p + 1
            while(q < len(nums) - 2 and nums[p] + nums[q] < target - nums[-1] - nums[-2]):
                q += 1

            while(q < len(nums) - 2):
                sum2 = self.twoSum(nums, q + 1, len(nums) - 1, target - nums[p] - nums[q])
                for s2 in sum2: 
                    if([nums[p], nums[q]] + s2 not in res):
                        res.append([nums[p], nums[q]] + s2)
                q += 1
            p += 1
        return res

    def twoSum(self, nums, b, e, target):
        if(b >= e): return []
        s = set()
        res = []
        print b , e
        for i in xrange(b, e + 1):
            if(target - nums[i] in s): res.append([target - nums[i], nums[i]])
            s.add(nums[i])
        return res
    def twoSum2(self, nums, b, e, target):
        i, j = b, e
        if(b >= e): return
        res = []
        print nums[b], nums[e], target
        while(i < j):
            if(nums[i] + nums[j] == target): res.append([nums[i], nums[j]])
            elif(nums[i] + nums[j] > target): j -= 1
            else: i += 1
        return res
# Accepted Solution
s = Solution()
nums = [-3,-2,-1,0,0,1,2,3]
nums2 = [-474,-445,-442,-426,-410,-382,-369,-367,-356,-351,-339,-335,-335,-320,-318,-313,-276,-250,-227,-215,-209,-209,-200,-198,-189,-183,-154,-149,-138,-134,-121,-110,-97,-93,-86,-66,-61,-54,-33,-12,-9,2,6,13,30,59,82,86,88,111,132,159,162,193,204,220,225,229,231,275,314,327,332,386,400,440,452,457,485]
t2 = 3456
t = 0
print s.fourSum(nums, t)