// Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

// For the last line of text, it should be left justified and no extra space is inserted between words.

// For example,
// words: ["This", "is", "an", "example", "of", "text", "justification."]
// L: 16.

// Return the formatted lines as:
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]
// Note: Each word is guaranteed not to exceed L in length.

// click to show corner cases.

// Corner Cases:
// A line other than the last line might contain only one word. What should you do in this case?
// In this case, that line should be left-justified.


public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        int len = words.length;
        if(words == null || len == 0)
            return result;
        
        int count = 0;
        int last = 0;
        for(int i = 0; i < len; i ++){
            if(count + words[i].length() + i - last <= L){ // ith word can be added in
                count += words[i].length();
            }else{ // put last to (i - 1)th words to result
                int spaceCount = L - count;
                int spaceNum = 0;
                int spaceExtra = 0;
                if(i - 1 - last > 0){ // more than one word to be added to this line
                    spaceNum = spaceCount / (i - 1 - last);
                    spaceExtra = spaceCount % (i - 1 - last);
                }
                StringBuilder sb = new StringBuilder();
                for(int j = last; j < i; j++){
                    sb.append(words[j]);
                    if(j < i - 1){
                        for(int k = 0; k < spaceNum; k++){
                            sb.append(" ");
                        }
                        if(spaceExtra > 0){
                            sb.append(" ");
                            spaceExtra --;
                        }
                    }
                }
                
                for(int k = sb.length(); k < L; k ++){
                    sb.append(" ");
                }
                result.add(sb.toString());
                // next line starts from ith word 
                count = 0;
                last = i;
            }
        }
        
        //last line
        StringBuilder sb = new StringBuilder();
        for(int i = last; i < len; i ++){
            sb.append(words[i]);
            if(sb.length() < L)
                sb.append(" ");
        }
        
        for(int j = sb.length(); j < L; j++){
            sb.append(" ");
        }
        result.add(sb.toString());
        
        return result;
    }
}