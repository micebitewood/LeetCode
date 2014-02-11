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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        res = new ArrayList<Interval>();
        Collections.sort(intervals, new IntervalComparator());
        Deque<Interval> stack = new ArrayDeque<Interval>(intervals);
        int s = 0;
        int e = -1;
        while (stack.size() > 0) {
            Interval interval = stack.pop();
            if (s > e) {
                s = interval.start;
                e = interval.end;
            } else if (interval.start <= e) {
                e = Math.max(e, interval.end);
            } else {
                res.add(new Interval(s, e));
                s = interval.start;
                e = interval.end;
            }
        }
        if (s <= e)
            res.add(new Interval(s, e));
        return res;
    }
    
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start == 0 ? i1.end - i2.end : i1.start - i2.start;
        }
    }
}