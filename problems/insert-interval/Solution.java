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
        ArrayList<Interval> res = new ArrayList<Interval>();
        int left = newInterval.start;
        int right = newInterval.end;
        boolean done = false;
        for (Interval interval : intervals) {
            if (interval.end < left)
                res.add(interval);
            else if (interval.start > right) {
                if (!done) {
                    res.add(new Interval(left, right));
                    done = true;
                }
                res.add(interval);
            } else {
                if (interval.start < left) {
                    left = interval.start;
                }
                if (interval.end > right) {
                    right = interval.end;
                    res.add(new Interval(left, right));
                    done = true;
                }
            }
        }
        if (!done)
            res.add(new Interval(left, right));
        return res;
    }
}