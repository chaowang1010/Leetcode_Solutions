// Given a set of distinct integers, S, return all possible subsets.

// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If S = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.length == 0) return result;
        
        result.add(new ArrayList<Integer>()); // add [] 
        Arrays.sort(S);
        for(int i = 0; i < S.length; i ++){
            int size = result.size();  // 
        	for(int j = 0; j < size; j++){
        		ArrayList<Integer> temp = new ArrayList<Integer>(result.get(j));
        		temp.add(S[i]);
        		result.add(temp);
        	}
        }

        return result;
    }

    // Recursive
    private ArrayList<ArrayList<Integer>> subsetsHelper(int[] S,   
     	int cur, ArrayList<ArrayList<Integer>> results) {  
   		// reach end of set -> add [] as a subset  
   		if (cur >= S.length) {  
     		results.add(new ArrayList<Integer>());  
     		return results;  
   		}  
   		// generate subsets with remaining elements  
   		results = subsetsHelper(S, cur+1, results);  
   		// append the current one to all subsets made up with remaining elements  
   		int curSize = results.size();  
   		while (curSize-- > 0) {  
     		ArrayList<Integer> res = new ArrayList<Integer>();  
		     res.add(S[cur]);  
		     res.addAll(results.get(curSize));  
		     results.add(res);  
		   }  
  		return results;  
 	}  
   
 	public ArrayList<ArrayList<Integer>> subsets(int[] S) {  
   		// sort the given set  
   		Arrays.sort(S);  
   		// generate subsets  
		return subsetsHelper(S, 0, new ArrayList<ArrayList<Integer>>());  
	}
}