// Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".


public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int maxLen = 0;
        int start = -1;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            } else {
                if(!stack.isEmpty()){ //match
                    stack.pop();
                    maxLen = stack.isEmpty()?Math.max(maxLen,i-start):Math.max(maxLen,i-stack.peek()); 
                } else{ // the parenthese ends
                    start = i;
                }
            }
        }
        return maxLen;
    }
}