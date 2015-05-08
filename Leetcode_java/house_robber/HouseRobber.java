// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.




public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        if(nums.length == 1)
            return dp[1];
        dp[2] = Math.max(nums[0], nums[1]);
        if(nums.length == 2)
            return dp[2];
        dp[3] = Math.max(nums[0] + nums[2], nums[1]);
        if(nums.length == 3)
            return dp[3];
        
        for(int i = 4; i <= nums.length; i ++ ){
            dp[i] = Math.max(dp[i - 3] , dp[i - 2]) + nums[i - 1];
        }
        
        return Math.max(dp[nums.length] , dp[nums.length - 1]);
    }
}