package algorithms;

public class A123_BestTimetoBuyandSellStockIII {
	
	public static void main(String[] args) {
		A123_BestTimetoBuyandSellStockIII a123 = new A123_BestTimetoBuyandSellStockIII();
		int[] stocks = {1, 7, 3, 8, 5};
//		int[] stocks = {1, 3, 8, 7, 3, 8, 5};
//		int[] stocks = {1, 2, 4};
//		int[] stocks = {1, 4, 2};
//		int[] stocks = {1,2,4,2,5,7,2,4,9,0};
//		int[] stocks = {1,2,4,2,5,7,10,2,4,9,0};

		System.out.println("" + a123.maxProfit(stocks));
	}
	
	//accepted solution
	public int maxProfit(int[] prices) {
		
		if(prices.length < 2) return 0;
		if(prices.length == 2) return Math.max(prices[1] - prices[0], 0);
		int[] diff = new int[prices.length];
		
		int i = 1;
		int min = prices[0];
		diff[0] = 0;
		while(i < prices.length) {
			if(prices[i] < min) min = prices[i];
			if(prices[i] - min > diff[i-1]) diff[i] = prices[i] - min;
			else diff[i] = diff[i - 1];
//			System.out.println(diff[i] + " " + i);
			i++;
		}
		i--;
		int result = 0;
		int max = prices[i];
		while(i>=0) {
			System.out.println(diff[i]);
			if(prices[i] > max) max = prices[i];
			if(diff[i] < 0) diff[i] = max - prices[i];
			else if(max - prices[i] > 0) diff[i] += max - prices[i];
			if(diff[i] > result) result = diff[i];
			System.out.println(result);

			i--;
		}
		
		return result;
	}
	public int maxProfit2(int[] prices) {
        int i = 0;
        int min2 = Integer.MAX_VALUE;
        int diff2 = 0;
        int max2 = Integer.MIN_VALUE;
        
        while(i < prices.length) {
        	
        	if(prices[i] > max2) max2 = prices[i];
        	if(prices[i] < min2) min2 = prices[i];
        	i++;
        }
        
        boolean _min = false;
        boolean _max = false;
        i = 0;
        int min1 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int diff1 = 0;
        int diff = 0;
        
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(i < prices.length - 2) {
        	if(prices[i] < min) min = prices[i];
        	if(prices[i+1] - min > diff1) diff1 = prices[i+1] - min;
//        	if(prices[i+2])
        	
        	i++;
        }
        
        
        while(i < prices.length - 1) {
        	if(!_max && !_min) diff2 = max2 - min2;
        	else if(_max && !_min) diff2 = prices[i+1] - prices[i];
        	else if(!_max && _min) diff2 = max2 - prices[i];
        	else diff2 = prices[i + 1]  - prices[i];
        	
        	if(prices[i + 1] == min2) _min = true;
        	
        	if(prices[i + 1] == max2) _max = true;
        	if(prices[i] < min1) {
        		min1 = prices[i];
        	}
        	
        	if(prices[i + 1] - min1 > diff1) diff1 = prices[i + 1] - min1;
        	if(diff1 + diff2 > diff) diff = diff1 + diff2;
            i++;
        }
        
//		System.out.println(diff1 + " " + diff2);

        return diff;
    }
}
