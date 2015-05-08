// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.



// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.

public class Solution {
    // Recursive...
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        searchCom(digits, 0, "", result);
        return result;
    }
    
    public void searchCom(String digits, int start, String s, ArrayList<String> result){
        if(s.length() == digits.length()) {
            result.add(s);
            return;
        }
        
        for(int i = start; i < digits.length(); i++){
            int num = Character.getNumericValue(digits.charAt(i));
            String letters = mapDigits(num);
            // what about "0"
            if (num == 0) continue;
            for(int j = 0; j < letters.length(); j++){
                s += letters.charAt(j);
                searchCom(digits, i + 1, s, result);
                s = s.substring(0, s.length() - 1);
            }
        }
        
    }
    
    public String mapDigits(int num){
        String letters = "";
        switch(num){
            case 2: letters = "abc"; break;
            case 3: letters = "def"; break;
            case 4: letters = "ghi"; break;
            case 5: letters = "jkl"; break;
            case 6: letters = "mno"; break;
            case 7: letters = "pqrs"; break;
            case 8: letters = "tuv"; break;
            case 9: letters = "wxyz"; break;
            case 0: letters = " "; break;
        }
        return letters;
    }
}