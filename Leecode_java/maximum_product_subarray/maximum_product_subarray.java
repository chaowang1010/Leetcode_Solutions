// Find the contiguous subarray within an array (containing at least one number) which has the largest product.

// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.

public class Solution {
    public int maxProduct(int[] A) {
        if(A == null || A.length == 0) return 0;
        if(A.length == 1) return A[0];

        int maxPre = A[0];
        int minPre = A[0];
        int maxPro = A[0];

        for(int i = 1; i < A.length; i ++){
        	int preMax = maxPre;
        	maxPre = Math.max( Math.max(A[i], maxPre * A[i]), minPre * A[i]);
        	minPre = Math.min(Math.min(A[i], minPre * A[i]), preMax * A[i]);
        	maxPro = Math.max(maxPro, maxPre);
        }
        return maxPro;
    }
}