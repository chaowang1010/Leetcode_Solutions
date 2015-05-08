// Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

// Below is one possible representation of s1 = "great":

//     great
//    /    \
//   gr    eat
//  / \    /  \
// g   r  e   at
//            / \
//           a   t
// To scramble the string, we may choose any non-leaf node and swap its two children.

// For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

//     rgeat
//    /    \
//   rg    eat
//  / \    /  \
// r   g  e   at
//            / \
//           a   t
// We say that "rgeat" is a scrambled string of "great".

// Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

//     rgtae
//    /    \
//   rg    tae
//  / \    /  \
// r   g  ta  e
//        / \
//       t   a
// We say that "rgtae" is a scrambled string of "great".

// Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.


public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length())
          return false;
        if(s1.length() == 0 && s2.length() == 0)
          return true;
        // dp[i][j][k] = true iff s2.substring(j,j+k+1) is a scambled string of s1.substring(i,i+k+1)  
        boolean[][][] dp = new boolean[s1.length()][s2.length()][s1.length()];
        for(int i = 0; i < s1.length(); i++){
          for(int j = 0; j< s2.length(); j++){
            dp[i][j][0] = (s1.charAt(i)==s2.charAt(j));
          }
        }
        for(int k = 1; k < s1.length(); k++){  // k: length
            for(int i = 0; i < s1.length() - k; i++){
              for(int j = 0; j< s2.length() - k; j++){
                dp[i][j][k] = false;  
                 for (int p=0; p < k; ++p) { // p: split into [0..p] and [p+1..k]  
                   if ((dp[i][j][p] && dp[i+p+1][j+p+1][k-p-1])  
                       || (dp[i][j+k-p][p] && dp[i+p+1][j][k-p-1])) {  
                     dp[i][j][k] = true;  
                     break;  
                   }  
                 }  
              }
          }
        }
        return dp[0][0][s1.length()-1];
    }
}