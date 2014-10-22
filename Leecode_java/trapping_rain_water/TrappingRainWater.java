// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

public class Solution {

	// This problem is similar to the problem of finding Largest Rectangle in Histogram. 
	// So, we can use a similar strategy here:
	// Use Stack to store the index of a bar;
	// If the current one is smaller then the top of the stack, 
	// push it to stack;
	// Otherwise, pop up the top until stack is empty or top is greater than the current one, 
	// add up the volume, push the current one to stack.
	// The tricky part is what is the volume to be added each time when we pop up a value from the stack.

    public int trap(int[] A) {
    	// skip zeros
		int i = 0;
		while(i < A.length && A[i] == 0){
			i ++;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int vol = 0;
		while(i < A.length){
			if(stack.isEmpty()) {
				stack.push(i);
				i++;
			} else if(A[i] > A[stack.peek()]){
				
			}
		}   
    }
}