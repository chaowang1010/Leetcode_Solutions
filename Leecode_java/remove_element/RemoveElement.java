public class Solution {
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        if(len == 0) return 0;
        int j = 0;
        int count = 0;
        while(j < len){
            if(A[j] == elem){
                count++;
            } else {
                A[j - count] = A[j];
            }
            j++;
        }
        return j - count;
    }
}