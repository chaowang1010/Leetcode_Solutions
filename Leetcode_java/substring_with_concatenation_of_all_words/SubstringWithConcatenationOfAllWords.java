// You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

// For example, given:
// S: "barfoothefoobarman"
// L: ["foo", "bar"]

// You should return the indices: [0,9].
// (order does not matter).

public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(L.length == 0) return null;

        // store the words and frequencies in a hash table  
   		HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String l : L){
        	if(map.containsKey(l)){
        		map.put(l, map.get(l) + 1);
        	}else{
        		map.put(l, 1);
        	}
        }

        int len = L.length;
        int worldLen = L[0].length();
        
        // check from each String starting with i, if it is a contatenation
        for(int i = 0; i <= S.length() - worldLen * len; i++){
        	HashMap<String, Integer> temp = new HashMap<String, Integer>(map);
        	for(int j = i; j <= S.length() - worldLen && !temp.isEmpty(); j+=worldLen){ //!temp.isEmpty
        		String sub = S.substring(j, j + worldLen);
        		if(!temp.containsKey(sub)) break;
        		if(temp.get(sub) == 1){
        			temp.remove(sub);
        		}else{
        			temp.put(sub, temp.get(sub) - 1);
        		}
        	}
        	if(temp.isEmpty())
        		result.add(i);
        }
        return result;
    }
}