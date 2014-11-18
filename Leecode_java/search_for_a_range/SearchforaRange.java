// Given a sorted array of integers, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].

// public class Solution {
//     public int[] searchRange(int[] A, int target) {
        
//     }
// }

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if(A == null || A.length == 0) return result;

        int left = 0, right = A.length - 1;
        int mid = (left + right) / 2;
        while(left <= right){
        	mid = (left + right) / 2;
        	if(A[mid] == target){
        		result[0] = mid;
        		result[1] = mid;
        		break;
        	} else if(A[mid] < target){
        		left = mid + 1;
        	} else {
        		right = mid - 1;
        	}
        }

        if(A[mid] != target) return result;
        int oldMid = mid;

        //Search for the right
        left = mid;
        right = A.length - 1;
        while(left <= right){
            int newMid = (left + right) / 2;
        	if(A[newMid] == target){
        		left = newMid + 1;
        	}else{
        		right = newMid - 1;
        	}
        }
        result[1] = right;
        //Search for the left
        left = 0;
        right = oldMid;
        while(left <= right){
        	int newMid = (left + right) / 2;
        	if(A[newMid] == target){
        		right = newMid - 1;
        	}else{
        		left = newMid + 1;
        	}
        }
        result[0] = left;


        return result;
    }
}