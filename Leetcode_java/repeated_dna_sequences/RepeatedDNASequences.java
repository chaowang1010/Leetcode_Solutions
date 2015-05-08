public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> result = new ArrayList<String>();
        if(s.length() < 11) return result;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Character, Integer> seq = new HashMap<Character, Integer>();
        seq.put('A',1);seq.put('C',2);seq.put('G',3);seq.put('T',4);
        
        int x = 0; 
        for(int i = 0; i < 10; i++){
            x = (x<<2) | (seq.get(s.charAt(i)) - 1);
        }
        map.put(x, 1);
        
        int mask = (1<<20) - 1;
        for(int i = 10; i < s.length() ; i++){
            x = (x<<2) | (seq.get(s.charAt(i)) - 1);
            x = x & mask;
            if(map.containsKey(x)){
                if(map.get(x) == 1){
                    result.add(intToString(x));
                    map.put(x, -1);
                }
            }else{
                map.put(x, 1);
            }
        }
        return result;
    }
    
    public String intToString(int x){
        String s = new String();
        for(int i = 0; i < 10; i++){
            int temp = x & 3;
            if(temp == 0) s = 'A' + s;
            if(temp == 1) s = 'C' + s;
            if(temp == 2) s = 'G' + s;
            if(temp == 3) s = 'T' + s;
            x = x >> 2;
        }
        return s;
    }
}