// Given an absolute path for a file (Unix-style), simplify it.

// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"


public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.charAt(0) != '/') return null;

        String[] splits = path.split("/");
        Stack stack = new Stack();
        for(int i = 0; i < splits.length; i ++){
        	if(splits[i].equals("..") && !stack.isEmpty())
        		stack.pop();
        	else if(!splits[i].equals(".") && !splits[i].equals("..") && !splits[i].isEmpty())
        		stack.push(splits[i]);
        }

        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
        	sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }
}
