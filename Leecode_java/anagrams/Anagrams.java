// Given an array of strings, return all groups of strings that are anagrams.

// Note: All inputs will be in lower-case.

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        if(strs == null) return result;

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for(String str : strs){
        	char[]  c = str.toCharArray();
        	Arrays.sort(c);
        	String temp = new String(c);
        	if(!map.containsKey(temp)){ // do not find a mapping, put in the key and str
        		ArrayList<String> tempList = new ArrayList<String>();
        		tempList.add(str);
        		map.put(temp, tempList);
        	} else { // find a mapping, add str to the key
        		map.get(temp).add(str); 
        	}
        }

       	for (ArrayList<String> list: map.values()){
           if (list.size()>1){
               for (String str:list){
                  result.add(str);
                }
            }
        }
        return result;
    }
}