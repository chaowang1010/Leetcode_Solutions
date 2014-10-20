public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int end = m + n - 1;
        m --; 
        n --;
        while(n >= 0){
            if(m < 0 ||B[n] > A[m]){
                A[m + n + 1] = B[n];
                n --;
            } else{
                A[m + n + 1] = A[m];
                m --;
            }
        }
    }
}