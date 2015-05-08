// Write a function to find the longest common prefix string amongst an array of strings.


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        
        int len = strs.length;
        int i = 0;
        while(i < strs[0].length()){
            char c = strs[0].charAt(i);
            for(int j = 1; j < len; j++){
                if(i >= strs[j].length() ||c != strs[j].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }
        return strs[0];
    }
}