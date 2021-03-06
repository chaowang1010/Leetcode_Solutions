// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

// You may assume that the intervals were initially sorted according to their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals.size() == 0){
            result.add(newInterval);
            return result;
        }
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start ){
            result.add(intervals.get(i));
            i++;
        }
        
        if(i < intervals.size()){
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        }
        result.add(newInterval);
        
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        
        while(i < intervals.size()){
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }
}