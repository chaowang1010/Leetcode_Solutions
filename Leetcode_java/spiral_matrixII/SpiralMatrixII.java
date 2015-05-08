// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// For example,
// Given n = 3,

// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]


public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int value = 0;
        for(int level = 0; level < n; ++level, --n ){
            for(int i = level; i < n; i ++) matrix[level][i] = ++value;
            for(int i = level + 1; i < n; i ++) matrix[i][n - 1] = ++value;
            for(int i = n - 2; i >= level ; i --) matrix[n - 1][i] = ++value;
            for(int i = n - 2; i > level; i --) matrix[i][level] = ++value;
        }
        return matrix;
    }
}