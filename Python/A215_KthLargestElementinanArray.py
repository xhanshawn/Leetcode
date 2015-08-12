class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {integer}
    # def findKthLargest(self, nums, k):
    #     nums.sort()
    #     heapify([], 1)
    #     return nums[-k]
    #....accepted solution any way...
    def findKthLargest(self, nums, k):
        hf = HeapFactory()
        hf.heapSort(nums)
        return nums[k - 1]
class HeapFactory:
	def min_heapify(self, nums, i, size):
		left = 2 * i + 1
		right = 2 * i + 2
		least = i	
		if(left < size and nums[left] < nums[i]): least = left
		if(right < size and nums[right] < nums[least]): least = right
		if(not least == i):
			t = nums[i]
			nums[i] = nums[least]
			nums[least] = t
			self.min_heapify(nums, least, size)
			
	def buildMinHeap(self, nums):
		for x in xrange(len(nums)/2, -1, -1):
			self.min_heapify(nums, x, len(nums))
	def heapSort(self, nums):
		self.buildMinHeap(nums)
		size = len(nums)
		for x in xrange(len(nums) - 1, 0, -1):
			t = nums[0]
			nums[0] = nums[x]
			nums[x] = t
			size -= 1
			self.min_heapify(nums, 0, size)

s = Solution()
hf = HeapFactory()
nums = [1,7,6,3,2,4,5]
hf.heapSort(nums)
print s.findKthLargest(nums, 2)