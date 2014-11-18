// Given two numbers represented as strings, return multiplication of the numbers as a string.

// Note: The numbers can be arbitrarily large and are non-negative.


public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        int[] n1 = new int[num1.length()];
        int[] n2 = new int[num2.length()];

        for(int i = 0; i < num1.length(); i++){
        	n1[num1.length() - 1 - i] = num1.charAt(i) - '0';
        }
        for(int i = 0; i < num2.length(); i++){
        	n2[num2.length() - 1 - i] = num2.charAt(i) - '0';
        }

        int product = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num1.length() + num2.length() - 1; i++){
        	for(int k = 0; k <= i; k ++){
        		if(k < num1.length() && i - k < num2.length()){
        			product += n1[k] * n2[i - k];
        		}
        	}
        	sb.append((char)(product%10 + '0'));
        	product /= 10;
        }

        if(product > 0) sb.append((char) (product + '0'));
        String result = sb.reverse().toString();
        return result;
    }
}