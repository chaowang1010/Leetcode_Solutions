// Given a roman numeral, convert it to an integer.

// Input is guaranteed to be within the range from 1 to 3999.

 /* int: 1000, 900, 500, 400, 100, 90, 50,  40,  10,  9,  5,  4,  1  
  * roman: "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"  
  */  


public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int result = 0;
        
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if( (c == 'C' || c == 'X' || c =='I')
            && (i + 1 < s.length()) && map.get(s.charAt(i+1)) > map.get(c) ){
                result += map.get(s.charAt(i + 1)) - map.get(c);
                i++;
            }else{
                result += map.get(c);
            }
        }
        return result;
    }
}