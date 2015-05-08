// Follow up for N-Queens problem.

// Now, instead outputting board configurations, return the total number of distinct solutions.


public class Solution {
    int result;  //!!!
    public int totalNQueens(int n) {
        result = 0;
        helper(n, 0 , new int[n]);
        return result;
    }
    
    public void helper(int n , int row, int[] columnForRow){
        if(row == n){
            result++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            columnForRow[row] = i;
            if(check(row, columnForRow)){
                helper(n, row + 1, columnForRow);
            }
        }
    }
    
    public boolean check(int row, int[] columnForRow){
        for(int i=0;i<row;i++){  
            if(columnForRow[row]==columnForRow[i] || Math.abs(columnForRow[row]-columnForRow[i])==row-i)  
                return false;  
        }  
        return true;
    }
}