// Given a string containing only digits, restore it by returning all possible valid IP address combinations.

// For example:
// Given "25525511135",

// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        partition(s, 0, new StringBuilder(), result);
        return result;
    }
    
    public void partition(String s, int n, StringBuilder address, ArrayList<String> result){
        if(n == 3){  //find one
            if(isValidIP(s)){
                result.add(address.toString() + s);
            }
            return;   // ???
        }
        
        int lenPre = address.length();
        for(int i = 1;i <= 3 && i < s.length(); i++){
            String temp = s.substring(0, i);
            if(isValidIP(temp)) partition(s.substring(i), n + 1, address.append(temp).append("."), result);
            address.delete(lenPre, address.length());
        }
    }
    
    public boolean isValidIP(String s){
        if(s.length() < 1 || s.length() > 3) return false;
        if(s.charAt(0) == '0' && s.length() != 1) return false; // Do not Forget!
    
        int num = Integer.parseInt(s);  
        if (num >= 0 && num <= 255) return true; 
        return false;
    }
}