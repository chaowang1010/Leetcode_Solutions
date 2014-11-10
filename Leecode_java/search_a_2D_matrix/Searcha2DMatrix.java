// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// For example,

// Consider the following matrix:

// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// Given target = 3, return true.


// return 1, if n == 0;
// return 1/pow(x, -n), if n < 0;
// return x^(n/2) * x^(n/2), if n is even;
// return x * x^(n/2) * x^(n/2), if n is odd.


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int left = 0;
        int right = matrix.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(target == matrix[mid][0]) return true;
            if(target > matrix[mid][0]) left = mid + 1;
            else right = mid - 1;
        }
        // search in the row
        int row = right; // not left
        if(row < 0) return false; // This is !!!
        left = 0;
        right = matrix[0].length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(target == matrix[row][mid]) return true;
            if(target > matrix[row][mid]) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}