// Follow up for "Find Minimum in Rotated Sorted Array":
// What if duplicates are allowed?

// Would this affect the run-time complexity? How and why?
// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// The array may contain duplicates.

public class Solution {

	// brute force O(n)
    public int findMin(int[] num) {
        if(num.length == 1) return num[0];
        for(int i = 0; i < num.length - 1; i++){
            int j = i + 1;
            if(num[j] < num[i]) return num[j];
        }
        return num[0];
    }
}