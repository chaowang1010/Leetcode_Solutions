// Longest Palindromic Substring

// Given a string S, find the longest palindromic substring in S. 
// You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
        	return "";
        int maxLen = 0;
        String result = "";
        for(int i = 0; i < 2 * s.length() - 1; i++){
        	int start = i / 2;
        	int end = start;
        	if(i % 2 == 1) // the middle of two characters
        		end ++;
        	String curr = findLongest(s, start, end);
        	if(maxLen < curr.length()){
        		maxLen = curr.length();
        		result = curr;
        	}
        }
        return result;
    }

    public String findLongest(String s, int start, int end){
    	while(start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)){
    		start --;
    		end ++;
    	}
    	return s.substring(start + 1, end);
    }
}