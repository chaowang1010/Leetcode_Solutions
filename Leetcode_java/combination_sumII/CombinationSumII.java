// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// Each number in C may only be used once in the combination.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
// A solution set is: 
// [1, 7] 
// [1, 2, 5] 
// [2, 6] 
// [1, 1, 6] 

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        searchSum(num, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void searchSum(int[] num, int target, int start, 
    	ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result){
    	if(target < 0) return;

    	if(target == 0){
    		ArrayList<Integer> temp = new ArrayList<Integer>(path);
    		result.add(temp);
    		return;
    	}

    	for(int i = start; i < num.length; i++){
    		if(i > start && num[i] == num[i - 1]) continue;  // skip duplicates
    		path.add(num[i]);
    		searchSum(num, target - num[i], i + 1, path, result);   // i + 1
    		path.remove(path.size() - 1);
    	}
    }
}