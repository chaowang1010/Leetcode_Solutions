public class Solution{
	    // brute force... will not work because of  Time Limit Exceeded
// 	public int[] twoSum(int[] numbers, int target){
// 		int[] pos = new int[2];
// 		int len = numbers.length;

// 		for(int i = 0; i < len - 1; i++){
// 			for(int j = i + 1; j < len; j++){
// 				if(numbers[i] + numbers[j] == target){
// 					pos[0] = i;
// 					pos[1] = j;
// 					return pos;
// 				}
// 			}
// 		}
// 		return pos;
// 	}


	// O(n) Hashmap  ---java.util.HashMap<K,V>
	//                  public V get(Object key)
	// 					public boolean containsKey(Object key)
	//					public V put(K key, V value)
    public int[] twoSum(int[] numbers, int target) {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	int[] result = new int[2];
 
	for (int i = 0; i < numbers.length; i++) {
		if (map.containsKey(numbers[i])) {
			int index = map.get(numbers[i]);
			result[0] = index+1 ;
			result[1] = i+1;
			break;
		} else {
			map.put(target - numbers[i], i);
		}
	}
 
	return result;
    }
}