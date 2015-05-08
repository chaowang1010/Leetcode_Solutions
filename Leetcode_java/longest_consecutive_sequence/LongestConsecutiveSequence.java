// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

// Your algorithm should run in O(n) complexity.

public class Solution {
    public int longestConsecutive(int[] num) {
        // can not sort, because sorting is at least O(nlog(n))
        if(num == null || num.length == 0) return 0;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int i = 0; i < num.length; i++)
            map.put(num[i], false);
            
        int maxLen = 0;
        for(int i = 0; i < num.length; i ++){
            if(map.get(num[i]) == false){
                map.put(num[i], true);
                int len = findConsecutive(map, num[i] - 1, - 1); //find the left sequence
                len += findConsecutive(map, num[i] + 1, 1); // find the right sequence
                len += 1;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
    
    public int findConsecutive(HashMap<Integer, Boolean> map, int num, int step){
        int len = 0;
        while(map.containsKey(num)){
            len ++;
            map.put(num, true);  // do not have to find numbers that ready visit
            num += step;
        }
        return len;
    }
}