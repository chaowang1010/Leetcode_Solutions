// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');

        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	if(map.keySet().contains(c)){  // left hit
        		stack.push(c);
        	} else if(map.values().contains(c)) { //right hit
        		if(!stack.isEmpty() && map.get(stack.peek()) == c)
        			stack.pop();
        		else
        			return false;
        	}
        }
        return stack.isEmpty(); // !
    }
}