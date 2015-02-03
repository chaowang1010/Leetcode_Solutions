/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) 
            return 0;
        if(allSamePoints(points)) // corner case
            return points.length;
        int max = 0;
        for(int i = 0; i < points.length - 1; i ++){
            for(int j = i + 1; j < points.length; j ++){
                //if they are the same points
                if(points[i].x == points[j].x && points[i].y == points[j].y)
                    continue;
                int curr = 2;
                for(int k = 0; k < points.length; k ++){
                    if(k != i && k != j && (points[k].y - points[j].y) * (points[i].x - points[j].x) == (points[i].y - points[j].y) * (points[k].x - points[j].x) )
                        curr ++;
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }
    
    public boolean allSamePoints(Point[] points){  
        for(int i=1;i<points.length;i++){  
            if(points[0].y!=points[i].y || points[0].x!=points[i].x)  
                return false;  
        }  
        return true;  
    }  
}

