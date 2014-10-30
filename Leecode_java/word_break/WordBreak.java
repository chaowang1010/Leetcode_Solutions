// Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".


public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0) return false;
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 
        for(int len = 0; len < s.length(); len++){  // len = 0, s[i .. i]
        	for(int i = 0; i < s.length() - len; i++){
        		int j = i + len;
        		String sub = s.substring(i, j + 1);
        		if(dict.contains(sub)){
        			dp[i][j] = true;
        			continue;
        		}
        		for(int k = i; k < j; k ++){
        			if(dp[i][k] && dp[k+1][j]){
        				dp[i][j] = true;
        				break; // find one of the seg is ok
        			}
        		}
        	}
        }
        return dp[0][s.length() - 1];
    }
}