public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        
        if(k > len /2){
            int pro = 0;
            for(int i = 1; i < len; i ++){
                pro += Math.max(prices[i] - prices[i - 1], 0);
            }
            return pro;
        }
        
        int[] hold = new int[k + 1];
        int[] rels = new int[k + 1];
        for(int i = 0; i <= k; i++){
            hold[i] = Integer.MIN_VALUE;
            rels[i] = 0;
        }
        
        for(int i = 0; i < len; i ++){
            for(int j = k; j > 0; j--){
                rels[j] = Math.max(rels[j], hold[j] + prices[i]);
                hold[j] = Math.max(hold[j], rels[j - 1] - prices[i]);
            }
        }
        return rels[k];
    }
}