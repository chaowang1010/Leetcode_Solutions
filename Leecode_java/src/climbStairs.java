public class Solution {
    public int climbStairs(int n) {
        int pre = 1;  //Step 0 has to be 1;
        int curr = 1;
        if (n==0) return 0;
        if (n==1) return 1;
        for (int i = 2; i<=n ; ++i)
        {
            int temp = curr;
            curr = pre + curr;
            pre = temp;
        }
        return curr;
    }
}