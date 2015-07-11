package algorithms;

public class A121_BestTimetoBuyandSellStock {
	
	//I did a123 first. then the former two are really easy.
	public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int min = prices[0];
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] - min > max) max = prices[i] - min;
            if(prices[i] < min) min = prices[i];
        }
        
        return max;
    }
}
