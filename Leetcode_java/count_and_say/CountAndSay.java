// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return null;

        StringBuilder result = new StringBuilder("1");   // ""

        while(n > 1){
        	StringBuilder temp = new StringBuilder();
        	int count = 1;
        	for(int i = 1; i < result.length(); i++){
        		if(result.charAt(i) == result.charAt(i - 1)){ //count
        			count++;
        		} else { //say
        			temp.append(count);
        			temp.append(result.charAt(i - 1));
        			count = 1;  // reset
        		}
        	}
        	temp.append(count);
        	temp.append(result.charAt(result.length() - 1));
        	result = temp;
        	n --;
        }

        return result.toString();
    }
}