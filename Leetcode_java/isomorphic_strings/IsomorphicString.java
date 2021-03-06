// Given two strings s and t, determine if they are isomorphic.

// Two strings are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

// For example,
// Given "egg", "add", return true.

// Given "foo", "bar", return false.

// Given "paper", "title", return true.

// Note:
// You may assume both s and t have the same length.

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) 
            return false;
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        
        for(int i = 0; i < s.length(); i++){
            if(mapS[s.charAt(i)] != mapT[t.charAt(i)])
                return false;
            mapS[s.charAt(i)] = i + 1;
            mapT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}