package algorithms;

public class A11_ContainerWithMostWater {
	
	public static void main (String[] args) {
//		int[] height = {1,2,3,4};
//		int[] height = {3,2,1,3};
		int[] height = {2,1};


		
		A11_ContainerWithMostWater a11 = new A11_ContainerWithMostWater();
		System.out.println(a11.maxArea(height));
	}
	
	
	//brute force
	public int maxArea1(int[] height) {
        int i = 0;
        int max = Integer.MIN_VALUE;
        while(i < height.length) {
            int j = i + 1;
            while(j < height.length) {
                int area = (j - i) * (height[i] + height[j]);
                max = Math.max(area, max);
                j++;
            }
            i++;
        }
        
        return max/2;
    }
	
	//accepted solution
	//if height of i larger, then j move
	// else i move;
	//
	//an example show this:
	//  { 5, ... 1, ..........,8}
	// we start from 5 and 8,
	// when we arrive at 1, we only record area from 1 to 8;
	// no need to record 5 to 1, because we already record area from 5 to 8;
	// and we know latter must be larger than former 
	// so in this solution, we only keep moving the smaller value pointer, 
	// which means area out of two pointers in each iteration must be recorded or useless
	// which means we will find the max;
	public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        if(j < 1) return 0;
        while(i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            if(area > max) max = area;
            
            if(height[i] > height[j]) j--;
            else i++;
        }
        
        return max;
        
    }
	
	
}
