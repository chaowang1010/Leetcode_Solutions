// Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

// Only one letter can be changed at a time
// Each intermediate word must exist in the dictionary
// For example,

// Given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]
// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.

// Note:
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.


public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(dict == null || dict.size() == 0)
            return 0;
        
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> lengthQueue = new LinkedList<Integer>();
        
        wordQueue.add(start);
        lengthQueue.add(1);
        
        while(!wordQueue.isEmpty()){
            String currWord = wordQueue.pop();
            int currLength = lengthQueue.pop();
            
            if(currWord.equals(end)){
                return currLength;
            }
            
            for(int i = 0; i < start.length(); i++){
                char[] currWordArr = currWord.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    currWordArr[i] = c;
                    String newWord = new String(currWordArr);
                    if(dict.contains(newWord)){
                        wordQueue.add(newWord);
                        lengthQueue.add(currLength + 1);
                        dict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}