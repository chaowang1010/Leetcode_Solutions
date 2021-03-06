// Write an algorithm to determine if a number is "happy".

// A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

// Example: 19 is a happy number

// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1



public class Solution {
    public boolean isHappy(int n) {
        int temp1 = n;
        int temp2 = n;
        while(temp1 > 1){
            temp1 = square(temp1);
            if(temp1 == 1) return true;
            temp2 = square(square(temp2));
            if(temp2 == temp1) return false;
        }
        return true;
    }
    
    public int square(int n){
        int sq = 0;
        while(n > 0){
            int digit = n % 10;
            sq = sq + digit * digit;
            n = n / 10;
        }
        return sq;
    }
}