public class Solution {
    // Not Working... TLE error...
    // Basically all methods performed on a hashmap are expensive in terms of 
    // executiontime. Considering the implementation of a hashmap every insert / get
    // or keycheck requires a lot more code execution than simply checking an array 
    // or a stringbuilder. Internally (afaik) hashmap works with objects for key/value.
    // Auto casting or instantiation of objects is expensive.
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        if(s.length() < 2) return s.length();
        
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        while(i < s.length()){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,i);
            }else{
                maxLen = Math.max(maxLen, map.size());
                i = map.get(c);
                map.clear();
            }
            i++;
        }
        return Math.max(maxLen, map.size());
    }

    // Using String as the map, it cannot pass either....
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        if(s.length() < 2) return s.length();
        
        int i = 0;
        String temp = '';
        
        while(i < s.length()){
            char c = s.charAt(i);
            int index = temp.indexOf(c);
            if(index < 0){
                temp = temp + c;
            }else{
                maxLen = Math.max(maxLen, temp.length());
                i = index;
                temp = "";
            }
            i++;
        }
        return Math.max(maxLen, temp.length());
    }

    // TLE ... 
    public int lengthOfLongestSubstring(String s) {
        int[] prevPos = new int[Character.MAX_VALUE + 1];
        Arrays.fill(prevPos, -1);
        int substringBegin = 0;
        int maxSubstringLen = 0;
        for (int i = 0; i < s.length(); i++) {
            substringBegin = Math.max(substringBegin,
                    prevPos[s.charAt(i)] + 1);
            prevPos[s.charAt(i)] = i;
            maxSubstringLen = Math.max(maxSubstringLen, i - substringBegin
                    + 1);
        }
        return maxSubstringLen;
    }
    
}