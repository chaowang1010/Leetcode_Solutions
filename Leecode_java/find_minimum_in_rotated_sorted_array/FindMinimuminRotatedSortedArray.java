// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// You may assume no duplicate exists in the array.

public class Solution {

	// brute force O(n)
    public int findMin(int[] num) {
        if(num.length == 1) return num[0];
        for(int i = 0; i < num.length - 1; i++){
            int j = i + 1;
            if(num[j] < num[i]) return num[j];
        }
        return num[0];
    }

    // binary search O(log(n))
    public int findMin(int[] num){
    	int i = 0;
    	int j = num.length - 1;

    	while(i <= j){
    		if (num[i] <= num[j]) {
    		    return num[i];
        	}

    		int m = (i + j)/2;
    		if(num[i] <= num[m]){  // = make a difference
    			i = m + 1;
    		}else{
    			j = m;
    		}
    	}
    	return num[0];
    }
}
}