// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
// Note:
// You are not suppose to use the library's sort function for this problem.


// Follow up:
// A rather straight forward solution is a two-pass algorithm using counting sort.
// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
// Could you come up with an one-pass algorithm using only constant space?

public class Solution {

	// counting sort, using one pointer and two passes.
    public void sortColors(int[] A) {
        int red = 0, white = 0, blue = 0;
        for(int i = 0; i < A.length; i++){
        	switch(A[i]){
        		case 0: red++; break;
        		case 1: white++; break;
        		case 2: blue++; break;
        	}
        }
        // for(int i = 0; i < A.length; i++) {
        //     if(A[i] == 0)       red++;
        //     else if(A[i] == 1)  white++;
        //     else                blue++;
        // }
        for(int i = 0; i < A.length; i++){
        	if(red > 0){
        		A[i] = 0;
        		red--;
        	} else if(white>0){
        		A[i] = 1;
        		white--;
        	} else{
        		A[i] = 2;
        	}
        }
    }

    // One pass, two pointers
    public void sortColors(int[] A){
    	int redIndex = 0, blueIndex = A.length-1, temp = 0;
    	int i = 0;
    	while(i < blueIndex + 1){
    		if(A[i] == 0){
    			temp = A[redIndex];
    			A[redIndex] = 0;
    			A[i] = temp;
    			redIndex ++;
    			i++;
    			continue;
    		} else if(A[i] == 2){
    			temp = A[blueIndex];
    			A[blueIndex] = 2;
    			A[i] = temp;
    			blueIndex --;
    			continue;  // if the element is exchanged from blueIndex, the next one starts from it, not the followed. 
    		}
    		i++;
    	}
    }
}


