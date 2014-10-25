// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".

// Note:
// If there is no such window in S that covers all characters in T, return the emtpy string "".

// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

public class Solution {
    public String minWindow(String S, String T) {
        int lenT = T.length();
        int lenS = S.length();

        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();
        for(int i = 0; i < lenT; i++){
        	char c = T.charAt(i);
        	//mapS.put(c, 0);
        	if(mapT.containsKey(c)){
        		mapT.put(c, mapT.get(c) + 1);
        	}else{
        		mapT.put(c, 1);
        	}
        }

        int start = 0, end = 0;
        int foundChar = 0;
        int minWinSize = Integer.MAX_VALUE;
        String minWindow = "";
        while(end < lenS){
        	char c = S.charAt(end);
        	if(mapT.containsKey(c)){ //c is in T
        		if(mapS.containsKey(c)){
        		    if(mapS.get(c) < mapT.get(c)) // still need to find c
        				foundChar ++;
        			mapS.put(c, mapS.get(c) + 1);
        		} else {
        			foundChar ++;
        			mapS.put(c, 1);
        		}
        		
        	}
        	if(foundChar == lenT){ // end - start + 1 found all chars in T
        		char sc = S.charAt(start);
        		while (!mapT.containsKey(sc) || mapT.get(sc) < mapS.get(sc)) {
        			if(mapT.containsKey(sc) && mapT.get(sc) < mapS.get(sc)){
        				mapS.put(sc, mapS.get(sc) - 1);
        			}
        			start ++;
        			sc = S.charAt(start);
        		}
        		if(end - start + 1 < minWinSize){
        			minWinSize = end - start + 1;
        			minWindow = S.substring(start, end + 1);
        		}
        	}
        	end ++;
        }
        return minWindow;
    }
}