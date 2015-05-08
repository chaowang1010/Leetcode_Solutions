// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete at most two transactions.

// Note:
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];
        int min = prices[0];
        int max = prices[prices.length - 1];
        int profit = 0;
        
        for(int i = 1; i < prices.length; i ++){
            min = Math.min(min, prices[i]);
            dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
        }
        
        for(int i = prices.length - 2; i >= 0; i --){
            max = Math.max(max, prices[i]);
            dp2[i] = Math.max(dp2[i + 1], max - prices[i]);
        }
        
        for(int i = 0; i < prices.length; i ++){
            profit = Math.max(profit, dp1[i] + dp2[i]);
        }
        
        return profit;
    }
}