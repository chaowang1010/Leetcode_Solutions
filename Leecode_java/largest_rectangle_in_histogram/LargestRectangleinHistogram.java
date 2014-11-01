// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

// The largest rectangle is shown in the shaded area, which has area = 10 unit.

// For example,
// Given height = [2,1,5,6,2,3],
// return 10.

public class Solution {

    // Brute force ... Time Limit Exceeded....
    public int largestRectangleArea(int[] height) {
        int maxArea = 0;
        for(int start = 0; start < height.length - 1; start++){
        	int minHeight = height[start];
        	for(int end = start + 1; end < height.length; end++){
        		for(int i = start; i <= end; i++){
        			if(minHeight > height[i]) minHeight = height[i];
        		}
        		if(maxArea < minHeight * (end - start + 1)) maxArea = minHeight * (end - start + 1);
        	}
        }
        return maxArea;
    }

    // improvement... Time Limit Exceeded....
    public int largestRectangleArea(int[] height) {
        int maxArea = 0;
        for(int end = height.length - 1; end > 0 ; end--){
        	if(end < height.length - 1 && height[end] <= height[end + 1]) continue;  // skip the end to the peak
        	int minHeight = height[end];
        	for(int start = 0; start <= end; start++){
        		for(int i = start; i <= end; i++){
        			if(minHeight > height[i]) minHeight = height[i];
        		}
        		if(maxArea < minHeight * (end - start + 1)) maxArea = minHeight * (end - start + 1);
        	}
        }
        return maxArea;
    }


    // stack  O(n)
    public int largestRectangleArea(int[] height) {
    	if(height == null || height.length == 0) return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;

        while(i < height.length){
        	if(stack.isEmpty() || height[i] >= height[stack.peek()]){
        		stack.push(i);
        		i++;
        	} else {
        		int top = stack.pop();
        		maxArea = Math.max(maxArea, height[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
        	}
        }

        while(!stack.isEmpty()){
	        int top = stack.pop();
	        maxArea = Math.max(maxArea, height[top] *(stack.isEmpty() ? i : (i - stack.peek() - 1)));   
        }
        return maxArea;
    }
}