class Solution:
    # @param {integer[]} height
    # @return {integer}
    # after - orgin area = raining area
    def trap(self, height):
        origin = sum(height)
        i, j = 0, len(height) - 1
        after = 0
        last = 0
        while(i < j):
            # print after
            if(height[i] < height[j]):
                if(height[i] > last):
                    after += (height[i] - last) * (j - i + 1)
                    last = height[i]
                i += 1
            else:
                if(height[j] > last):
                    after += (height[j] - last) * (j - i + 1)
                    last = height[j]
                if(height[i] == height[j]): i += 1
                j -= 1
        if(i == j and height[i] > last): after += height[i] - last
        return after - origin
# Accepted..... one time ...OMG!!!!
s = Solution()
height = [0,1,0,2,1,0,1,3,2,1,2,1]
print s.trap(height)