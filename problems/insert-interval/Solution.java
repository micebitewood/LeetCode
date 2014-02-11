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
    ArrayList<Interval> res;
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        res = new ArrayList<Interval>();
        int l = newInterval.start;
        int r = newInterval.end;
        boolean completed = false;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (!completed) {
                if (r < interval.start) {
                    res.add(new Interval(l, r));
                    res.add(interval);
                    completed = true;
                    continue;
                } else if (l > interval.end) {
                    res.add(interval);
                    continue;
                }
                if (l > interval.start) {
                    l = interval.start;
                }
                if (r < interval.end) {
                    r = interval.end;
                }
            } else {
                res.add(interval);
            }
        }
        if (!completed)
            res.add(new Interval(l, r));
        return res;
    }
}