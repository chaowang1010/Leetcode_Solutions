public class Solution {
	// brute force... TLE...
    public int maxArea(int[] height) {
    	int maxWater = 0;
        for(int i = 0; i < height.length; i++){
        	for(j = i + 1; j < height.length; j++){
        		int area = (j - i) * Math.min(height[i], height[j]);
        		if(maxWater < area);
        			maxWater =  area;
        	}
        }
        return maxWater;
    }

    // Better solution
}