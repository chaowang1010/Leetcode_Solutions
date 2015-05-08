// Rotate Array 

// Rotate an array of n elements to the right by k steps.

// For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

// Note:
// Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for(int i = 0; i < (nums.length - k)/2; i ++){
            int temp = nums[i];
            nums[i] = nums[nums.length - k - 1 - i];
            nums[nums.length - k - 1 - i] = temp;
        }
        
        for(int i = 0; i < k/2; i ++){
            int temp = nums[nums.length - k + i];
            nums[nums.length - k + i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        
        for(int i = 0; i < nums.length/2; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }
}

public class Solution {
    // solution 2
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        while(k > 0){
            int temp = nums[nums.length - 1];
            for(int i = nums.length - 1; i > 0; i --){
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k --;
        }
    }
}