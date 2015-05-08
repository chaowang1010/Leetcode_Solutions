// The set [1,2,3,…,n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

// Note: Given n will be between 1 and 9 inclusive.

public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        int[] fact = new int[n];
        int[] num = new int[n];

        // Construct the array of numbers and factorials
   		num[0] = 1;
        for(int i = 1; i < n; i++){
        	num[i] = i + 1;
        	if(i == 1)
        		fact[i] = 1;
        	else
        		fact[i] = fact[i - 1] * i;
        }
        
        k--;
        for(int i = 0; i < n - 1; i ++){
        	int id = k / fact[n - 1 - i] + i;    // !!! + i
        	int number = num[id];
        	// set the numbers
        	for(int j = id; j > i; j --){
        		num[j] = num[j - 1];
        	}
        	num[i] = number;
        	while(k >= fact[n - 1 - i]) k -= fact[n - 1 - i];
        	//k -= fact[i] * (number - 1);
        }
        StringBuilder nums = new StringBuilder(); 
        for (int i=0; i<n; i++)  
            nums.append(num[i]);
        return nums.toString();    
    }
}