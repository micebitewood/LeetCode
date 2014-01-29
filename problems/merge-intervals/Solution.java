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
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return res;
        Collections.sort(intervals, new IntervalComparator());
        List<Integer> starts = new ArrayList<Integer>();
        List<Integer> ends = new ArrayList<Integer>();
        for (Interval interval : intervals) {
            starts.add(interval.start);
            ends.add(interval.end);
        }
        int i = 0;
        while (i < starts.size()) {
            int left = starts.get(i);
            int j = i;
            i++;
            int right = ends.get(j);
            while (i < starts.size() && starts.get(i) <= right) {
                i++;
                j++;
                if (ends.get(j) > right)
                    right = ends.get(j);
            }
            res.add(new Interval(left, right));
        }
        return res;
    }
    
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
}