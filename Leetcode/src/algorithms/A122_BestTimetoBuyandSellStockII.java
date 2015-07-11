package algorithms;

public class A122_BestTimetoBuyandSellStockII {
	
	//this problem is really like a joke
	//I tried to draw a tiny graph to find that it is really easy
	public int maxProfit(int[] prices) {
        // int[][] profit = new int[prices.length][prices.length];
        int profit = 0;;
        for(int i=1; i <prices.length; i++) {
            if(prices[i] - prices[i - 1] > 0) profit += prices[i] - prices[i - 1];
        }
        
        return profit;
    }
}
