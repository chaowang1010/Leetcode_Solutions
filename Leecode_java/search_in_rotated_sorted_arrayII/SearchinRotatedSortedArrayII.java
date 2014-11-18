// Follow up for "Search in Rotated Sorted Array":
// What if duplicates are allowed?

// Would this affect the run-time complexity? How and why?

// Write a function to determine if a given target is in the array.


public class Solution {
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0)
            return false;
            
        int left = 0, right = A.length - 1;
        
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(A[mid] == target) return true;
            
            if(A[right] > A[mid]){  // right is in order
                if(A[mid] < target && A[right] >= target){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }else if(A[right] < A[mid]){                // left is in order
                if(A[mid] > target && A[left]<= target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                right --;
            }
        }
        
        return false;
    }
}