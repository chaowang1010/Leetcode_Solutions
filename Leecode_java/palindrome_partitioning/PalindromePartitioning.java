// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return all possible palindrome partitioning of s.

// For example, given s = "aab",
// Return

//   [
//     ["aa","b"],
//     ["a","a","b"]
//   ]

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        searchPartition(s, 0 , new ArrayList<String>(), result);
        return result;
    }
    
    public void searchPartition(String s, int start, 
        ArrayList<String> item, ArrayList<ArrayList<String>> result){
        if(start == s.length()){
            ArrayList<String> temp = new ArrayList<String>(item);
            result.add(temp);
            return;
        }
        for(int i = start; i < s.length(); i ++){
            if(isPalindrome(s, start, i)){
                item.add(s.substring(start, i + 1));
                searchPartition(s, i + 1, item, result);
                item.remove(item.size() - 1);  // size...
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}