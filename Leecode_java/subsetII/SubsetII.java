Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


public class Solution {
    // Iteration...
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)   return result;
        
        result.add(new ArrayList<Integer>());
        //When hit a duplicate element,only append it to subsets that contains all previous duplicates.
        Arrays.sort(num);
        
        int count = 0;
        for(int i = 0; i < num.length; i ++){
            int size = result.size();
            // if the current number has duplicate previously
            if(i > 0 && num[i] == num[i - 1])
                count ++;
            else 
                count = 0;
            for(int j = 0; j < size; j++){
                // for duplicates, only append to subsets containing all previous duplicates
                if(count > 0 && (count > result.get(j).size() || result.get(j).get(result.get(j).size() - count) != num[i]))
                    continue;
                ArrayList<Integer> temp = new ArrayList<Integer>(result.get(j));
                temp.add(num[i]);
                result.add(temp);
            }
        }
        return result;
    }

    //Recursive ...
}