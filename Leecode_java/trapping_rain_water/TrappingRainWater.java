// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


public class Solution {
    public int trap(int[] A) {
        if(A.length <= 2) return 0;
        
        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];
        int max = A[0];
        
        for(int i = 0; i < A.length; i++){
            maxLeft[i] = max;
            if(max < A[i])
                max = A[i];
                
        }
        
        max = A[A.length - 1];
        for(int i = A.length - 1; i >= 0; i--){
            maxRight[i] = max;
            if(max < A[i])
                max = A[i];
        }
        
        int total = 0;
        for(int i = A.length - 1; i >= 0; i--){
            if(maxLeft[i] > A[i] && maxRight[i] > A[i])
               total += Math.min(maxLeft[i], maxRight[i]) - A[i]; 
                
        }        
        return total;
    }
}