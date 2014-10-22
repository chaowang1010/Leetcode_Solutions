/*
 
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 
 
A partially filled sudoku which is valid.
 
Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/
 

// Rules of Sudoku:
// Each row must have the numbers 1-9 occuring just once.
// Each column must have the numbers 1-9 occuring just once.
// And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
        	return false;

        ArrayList<boolean[]> row = new ArrayList<boolean[]>();
        ArrayList<boolean[]> col = new ArrayList<boolean[]>();
        ArrayList<boolean[]> block = new ArrayList<boolean[]>();

        for(int i = 0; i < 9; i ++){
        	row.add(new boolean[9]);
        	col.add(new boolean[9]);
        	block.add(new boolean[9]);
        }

        for(int i = 0; i < 9; i++){
        	for(int j = 0; j< 9; j++){
        		if(board[i][j] == '.'){
        			continue;
        		}

        		int c = board[i][j] - '1';
        		if(row.get(i)[c] == true || col.get(j)[c] == true || block.get(i/3*3+j/3)[c] == true)
        			return false;
        		row.get(i)[c] = true;
        		col.get(j)[c] = true;
        		block.get(i/3*3+j/3)[c] = true; // take care about the index.
        	}
        }
        return true;
    }
}