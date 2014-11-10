// Implement pow(x, n).


public class Solution {
    public double pow(double x, int n) {
        if(n == 0) return 1;
        //if(n < 0) return 1 / pow(x, -n); // overflow ...the range of integers is [-2^32, 2^32-1]
        int exp = Math.abs(n);
        double half = pow(x, exp >> 1);
        double result = half * half;
        if(exp % 2 == 1) 
            result *= x;
        return (n < 0) ? 1.0/result : result;
    }
}