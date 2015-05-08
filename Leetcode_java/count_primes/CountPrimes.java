// Description:

// Count the number of prime numbers less than a non-negative number, n

// click to show more hints.

// Credits:


public class Solution {
    public int countPrimes(int n) {
        boolean[] num = new boolean[n];
        int count = 0;
        
        for(int i = 2; i < n; i ++){
            if(!num[i]){
                count ++;
                for(int j = 2 * i; j < n; j = j + i){
                    num[j] = true;
                }
            }
        }
        return count;
    }
}