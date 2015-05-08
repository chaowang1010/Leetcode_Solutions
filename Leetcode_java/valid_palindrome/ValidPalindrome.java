public class Solution {
    boolean isLetter(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    public boolean isPalindrome(String s) {
        if(s.length()<1) return true;
        
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end){
            if(!isLetter(s.charAt(start))) {
                start++;
                continue;
            }
            if(!isLetter(s.charAt(end))) {
                end--;
                continue;
            }
            
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)) )
                return false;
            start ++;
            end --;
        }
        return true;
    }
}