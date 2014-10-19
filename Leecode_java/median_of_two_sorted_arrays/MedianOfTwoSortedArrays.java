public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int lenA = A.length;
        int lenB = B.length;
        int total = lenA + lenB;
       
        if (total % 2 != 0) {
            return ((double)findKthElement(A, B, total/2, 0, lenA - 1, 0, lenB - 1));
        } else {
            return (findKthElement(A, B, total/2 - 1, 0, lenA - 1, 0, lenB - 1) +
                    findKthElement(A, B, total/2, 0, lenA - 1, 0, lenB - 1)) /2;
        }
    }
   
    private double findKthElement(int[] A, int[] B, int kth, int startA, int endA, int startB, int endB){
        int sizeA = endA - startA + 1;
        int sizeB = endB - startB + 1;
       
        if (sizeA == 0) return B[startB + kth];
        if (sizeB == 0) return A[startA + kth];
        if (kth == 0) return A[startA] > B[startB] ? B[startB] : A[startA];
       
        //Binary Search
        int midA = sizeA * kth /(sizeA + sizeB);
        int midB = kth - midA - 1;
       
        //Match to the original index
        midA += startA;
        midB += startB;
       
        if (A[midA] < B[midB]) {
            kth -= midA - startA + 1;
            endB = midB;
            startA = midA + 1;
        } else {
            kth -= midB - startB + 1;
            endA = midA;
            startB = midB + 1;
        }
        return findKthElement(A, B, kth, startA, endA, startB, endB);
    }
    
}