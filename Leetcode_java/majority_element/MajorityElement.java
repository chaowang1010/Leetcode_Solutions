// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

// You may assume that the array is non-empty and the majority element always exist in the array.




public class Solution {
    
    // O(nlogn) with sort
    public int majorityElement(int[] num) {
        Arrays.sort(num);
        return num[num.length/2];
    }

    // O(n)
    public int majorityElement(int[] num) {
        int majorEle = num[0], count = 1;
        for(int i = 1; i < num.length; i++){
            if(num[i] == majorEle){
                count ++;
            }else if(count == 0){
                majorEle = num[i];
                count++;
            }else{
                count --;
            }
        }
        return majorEle;
    }
}