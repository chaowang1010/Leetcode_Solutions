// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

public class Solution {
    // brute force TLE  O(n^2)
    // public int maxProfit(int[] prices) {
    //     if(prices == null || prices.length < 1) return 0;
    //     int max = Integer.MIN_VALUE;
    //     for(int i = 0; i < prices.length; i ++){
    //         for(int j = i + 1; j < prices.length; j ++){
    //             if(max < prices[j] - prices[i])
    //                 max = prices[j] - prices[i];
    //         }
    //     }
    //     return max;
    // }

   	// One pass -  O(n)
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 1) return 0;
        
        int minPrices = prices[0];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++){
        	if(prices[i] < minPrices) 
        		minPrices = prices[i];
        	if(max < prices[i] - minPrices)
        		max = prices[i] - minPrices;
        }

        return max;
    }

    // DP 
    public int maxProfit(int[] prices) {
    	if(prices == null || prices.length < 1) return 0;

    	int pre = 0;
    	int curr = 0;

    	for(int i = 1; i < prices.length; i ++){
    		pre = Math.max(0, pre + prices[i] - prices[i - 1]);
    		curr = Math.max(curr, pre); // either sell it or keep it.
    	}
    	return curr;
    }

    // DP ... 
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;
        
        int low = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++){
            low = Math.min(low, prices[i - 1]);
            max = Math.max(max, prices[i] - low);
        }
        return max;
    }
}

    // return the days of transactions
    public int maxProfit(int[] prices) {  
	     int profit = 0, buyDay = 0, sellDay = 1;  
	     while (sellDay < prices.length) {  
	     	int curProfit = prices[sellDay] - prices[buyDay];  
	     	if (curProfit <= 0)  buyDay = sellDay;  
	     	profit = Math.max(curProfit, profit);  
	     	sellDay++;  
	   	}  
	    return profit;  
	}  
}