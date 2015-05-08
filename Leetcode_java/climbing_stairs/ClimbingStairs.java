// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return n;
        int pre = 1;
        int curr = 1;
        for(int i = 2; i <= n; i++){
            int temp = curr;
            curr = pre + curr;
            pre = temp;
        }
        return curr;
    }
}