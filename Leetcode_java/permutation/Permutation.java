// Given a collection of numbers, return all possible permutations.

// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].


public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return result;
        
        // when num has only one number
        if(num.length == 1){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(num[0]);
            result.add(temp);
            return result;
        }
        
        for(int i = 0; i < num.length; i++){
            int[] others = new int[num.length - 1];
            for(int j = 0; j < i && j < num.length; j++) others[j] = num[j];
            for(int j = i + 1; j < num.length; j++) others[j - 1] = num[j];
            
            // append the current number to the end of pernutations of n-1 subset
            for(ArrayList<Integer> perm : permute(others)){
                perm.add(num[i]);
                result.add(perm);
            }
        }
        return result;
    }


    // Iterative ... NP
    public ArrayList<ArrayList<Integer>> permute(int[] num) {  
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
    if(num == null || num.length==0)  
        return res;  
    ArrayList<Integer> first = new ArrayList<Integer>();  
    first.add(num[0]);  
    res.add(first);  
    for(int i=1;i<num.length;i++)  
    {  
        ArrayList<ArrayList<Integer>> newRes = new ArrayList<ArrayList<Integer>>();  
        for(int j=0;j<res.size();j++)  
        {  
            ArrayList<Integer> cur = res.get(j);  
            for(int k=0;k<cur.size()+1;k++)  
            {  
                ArrayList<Integer> item = new ArrayList<Integer>(cur);  
                item.add(k,num[i]);  
                newRes.add(item);  
            }  
        }  
        res = newRes;  
    }  
    return res;     
}  
}