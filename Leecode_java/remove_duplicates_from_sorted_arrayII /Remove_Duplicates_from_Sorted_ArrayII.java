public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if(len <= 2) return len;
        int i = 1;
        int j = 2;
        
        while(j < len){
            if(A[i] == A[j] && A[j] == A[i - 1])
                j++;
            else{
                i++;
                A[i] = A[j];
                j++;
            }
        }
        return i+1;
    }
}