Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        generator(n, 0 , 0, new StringBuilder(), result);
        return result;
    }
    
    public void generator(int n, int l, int r, StringBuilder s, ArrayList<String> result){
        if(n == l ){
            while(r < n) { s.append(")"); r ++;}
            result.add(s.toString());
            return;
        } else if(l == r){
                generator(n, l + 1 , r, s.append("("), result);
        } else{ 
            int len = s.length();
            generator(n, l + 1 , r, s.append("("), result);
            s = s.delete(len, s.length()); //
            generator(n, l , r + 1, s.append(")"), result);
        }
    }
}