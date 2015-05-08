Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return result;
        
        if(num.length == 1){
            ArrayList<Integer> temp= new ArrayList<Integer>();
            temp.add(num[0]);
            result.add(temp);
            return result;
        }
        
        HashMap<Integer, Boolean> visit = new HashMap<Integer, Boolean>();
        for(int i = 0; i < num.length; i ++){
            if(visit.get(num[i]) != null) continue;   
            visit.put(num[i] , true);
            int[] others = new int[num.length - 1];
            for(int j = 0; j < i && j < num.length; j++) others[j] = num[j];
            for(int j = i + 1; j < num.length; j++) others[j - 1] = num[j];
            
            // append the current number to the end of pernutations of n-1 subset
            for(ArrayList<Integer> perm : permuteUnique(others)){
                perm.add(num[i]);
                result.add(perm);
            }
        }
        return result;
    }
}