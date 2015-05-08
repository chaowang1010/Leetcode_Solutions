// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// For example,
// Given the following matrix:

// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].


public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;
        
        int m = matrix.length;
        int n = matrix[0].length;
        for(int level = 0; level < m && level < n; level++, m --, n --){
            for(int i = level; i <= n - 1; i ++){
                result.add(matrix[level][i]);
            }
            if(m - 1 == level) return result;  // check for ending
            for(int i = level + 1; i <= m - 1; i++){
                result.add(matrix[i][n - 1]);
            }
            if(n - 1 == level) return result;  // check for ending
            for(int i = n - 2; i >= level; i--){
                result.add(matrix[m - 1][i]);
            }
            for(int i = m - 2; i > level; i--){
                result.add(matrix[i][level]);
            }
        }
        return result;
    }
}