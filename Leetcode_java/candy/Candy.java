// There are N children standing in a line. Each child is assigned a rating value.

// You are giving candies to these children subjected to the following requirements:

// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// What is the minimum candies you must give?




public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) 
            return 0;
        
        int[] num = new int[ratings.length];
        num[0] = 1;
        for(int i = 1; i< ratings.length; i++){
            if(ratings[i] > ratings[i - 1])
                num[i] = num[i - 1] + 1;
            else
                num[i] = 1;
        }
        
        int total = num[ratings.length - 1];
        
        for(int i = ratings.length - 2; i >= 0; i--){
            int curr = 1;
            if(ratings[i] > ratings[i + 1])
                curr = num[i + 1] + 1;
            total += Math.max(curr, num[i]);
            num[i] = curr;  //
        }
        return total;
    }
}