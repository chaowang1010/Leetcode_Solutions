public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if(len < 2) return len;
        int i = 0;
        int j = 1;
        while(j < len){
            if(A[i] == A[j]){
                j++;
            } else{
                i++;
                A[i] = A[j];
                j++;
            }
        }
        return i + 1;
    }
}