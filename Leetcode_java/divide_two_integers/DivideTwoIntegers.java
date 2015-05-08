// Divide two integers without using multiplication, division and mod operator.


public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 1) return dividend;
        
        int result = 0;
        
        // boolean neg = false;
        // if( (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ){
        //     neg = true;
        //     divisor = -divisor;
        // }
        
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        
        while(a >= b){
            long c = b;
            int count = 0;
            while(c <= a){
                a -= c;
                c = c << 1;
                result += 1 << count; 
                count++;
            }
        }
        
        // if(!neg)
        //     return count;
        // else
        //     return -count;
        return (dividend>0)^(divisor>0) ? (int)(-result) : (int)result;
    }
}