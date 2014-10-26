// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

// For example, given the following triangle
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

// Note:
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

public class Solution {
	//DFS, Recursion  O(2^n) O(n)- spaces
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     return minimumTotal(triangle, 0, 0, 0, Integer.MAX_VALUE);
    // }

    // public int minTotalDFS(List<List<Integer>> triangle, int row, int col, int sum, int minSum){
    // 	int sum + = triangle.get(row).get(col);

    // 	if(row == triangle.size() - 1)//last row
    // 		return sum > minSum ? minSum : sum;
    	
    // 	minSum = minTotalDFS(triangle, row + 1, col, sum, minSum);
    // 	minSum = minTotalDFS(triangle, row + 1, col + 1, sum, minSum);

    // 	return minSum;
    // }

	// O(n^2)  O(n)
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0) return 0;

		int[] result = new int[triangle.size()];
		for(int i = 0; i < triangle.get(triangle.size() - 1).size(); i ++ ){  // set up as the last row.
			result[i] = triangle.get(triangle.size() - 1).get(i);
		}

		for(int i = triangle.size() - 2; i >= 0; i--){
			for(int j = 0; j < triangle.get(i).size(); j++){
				result[j] = Math.min(result[j], result[j + 1]) + triangle.get(i).get(j);
			}
		}
		return result[0];
	}

}