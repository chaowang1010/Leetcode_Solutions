// Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// The same repeated number may be chosen from C unlimited number of times.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 2,3,6,7 and target 7, 
// A solution set is: 
// [7] 
// [2, 2, 3] 

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        searchSum(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void searchSum(int[] candidates, int target, int start, 
    	ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result){
    	if( target < 0) return;  // start < 0 ||
    	if(target == 0){
    		ArrayList<Integer> temp = new ArrayList<Integer>(path);
    		result.add(temp);
    		return;
    	}

    	for(int i = start; i < candidates.length; i ++){
    		path.add(candidates[i]);  
       		searchSum(candidates, target - candidates[i], i, path, result);  
       		path.remove(path.size() - 1);
    	}
    }
}