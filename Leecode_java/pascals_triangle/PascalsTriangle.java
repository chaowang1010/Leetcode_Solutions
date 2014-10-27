// Given numRows, generate the first numRows of Pascal's triangle.

// For example, given numRows = 5,
// Return

// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]


public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numRows; i ++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            if(i == 0) temp.add(1);
            else {
                temp.add(1);
                for(int j = 1; j < i; j ++){
                    temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
                temp.add(1);
            }
            result.add(temp);
        }
        return result;
    }
}