// Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

// Return all such possible sentences.

// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].

// A solution is ["cats and dog", "cat sand dog"].


public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        int len = s.length();

        ArrayList<ArrayList<Integer>> record = new ArrayList<ArrayList<Integer>>(len);
        for(int i = 0; i < len; i++){
            record.add(new ArrayList<Integer>());
        }
        for(int i = len; i >= 0; i--){
            if(i == len || !record.get(i).isEmpty()){
                for(int j = i - 1; j >= 0; j --){
                    String sub = s.substring(j,i);
                    if(dict.contains(sub)){
                        record.get(j).add(i);
                    }
                }
            }
        }
        buildSolution(record,0,s,"",result);
        
        return result;
    }

    void buildSolution(ArrayList<ArrayList<Integer>> record, int current, String s, 
                String solution, ArrayList<String> solutionSet){
        
        //iterate on current character's word ending list
        for(Integer end : record.get(current)){
 
            String sub=s.substring(current,end);
            /*
                since the loop may have many iterations, we should keep the reference
                of "solution", rather than writing as "solution += ..."
            */
            String newSolution = solution+(current==0 ? sub : " "+sub);
            
            if(end == s.length()) 
                solutionSet.add(newSolution);
            else 
                buildSolution(record,end,s,newSolution,solutionSet);
        }
    }
 
}