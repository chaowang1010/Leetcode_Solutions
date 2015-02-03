// Given a collection of intervals, merge all overlapping intervals.

// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals.size() == 0) return result;
        
        Comparator<Interval> comp = new Comparator<Interval>()  
        {  
            @Override  
            public int compare(Interval i1, Interval i2)  
            {  
                if(i1.start==i2.start)  
                    return i1.end-i2.end;  
                return i1.start-i2.start;  
            }  
        };  
        Collections.sort(intervals,comp);  
        
        result.add(intervals.get(0));
        int i = 1;
        while(i < intervals.size()){
            if(result.get(result.size() - 1).end >= intervals.get(i).start)
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, intervals.get(i).end);
            else
                result.add(intervals.get(i));
            i ++;
        }
        return result;
    }
}