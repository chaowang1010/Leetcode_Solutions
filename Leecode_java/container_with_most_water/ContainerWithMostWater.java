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

    // Better solution We always move the shorter boundary of the two.  
    // By moving the shorter one, we may arrive at a higher boundary 
    // so as to get a greater volume (although width decreased); 
    // it is not necessary to move the higher one since no matter 
    // if the next height is greater or smaller, it won't change the volume 
    // 	-- the shorter boundary is the limit for a container.
    public int maxArea(int[] height) {
    	int maxWater = 0;
    	int i = 0, j = height.length - 1;
    	while(i < j){
    		maxWater = Math.max(maxWater, (j - i) * Math.min(height[i], height[j]));
    		if(height[i] < height[j])
    			i++;
    		else 
    			j--;
    	}
    	return maxWater;
    }
}