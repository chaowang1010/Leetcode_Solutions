public class Solution {

    // Similar to 3sum. O(n^2)
    public int threeSumClosest(int[] num, int target) {
        if(num.length < 3){
            return Integer.MAX_VALUE;
        }
        
        Arrays.sort(num);
        int result = num[0] + num[1] + num[2]; // can not be a maximum value, because it will overflow
        
        for(int i = 0; i < num.length - 2; i++){
            // skip duplicates
            if(i > 0 && num[i] == num[i-1]) continue;
            int j = i + 1;
            int k = num.length - 1;
            while(j < k){
                int sum = num[i] + num[j] + num[k];
                if(Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
                if(sum == target){
                    return sum;
                } 
                if(sum < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }
}