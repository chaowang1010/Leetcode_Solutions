// Given an integer, convert it to a roman numeral.

// Input is guaranteed to be within the range from 1 to 3999.


public class Solution {
    public String intToRoman(int num) {
        int[] numSpec = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        int i = 0;

        while(num > 0){
        	int digit = num / numSpec[i];
        	num -= numSpec[i] * digit;
        	for(;digit > 0; digit --){
	        	result.append(symbols[i]);
	        }
	        i ++;
        }
        return result.toString();
    }
}