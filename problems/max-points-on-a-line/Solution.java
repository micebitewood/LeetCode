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
        if (points == null || points.length == 0)
            return 0;
        if (points.length == 1)
            return 1;
        int max = 2;
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            Map<String, Integer> count = new HashMap<String, Integer>();
            int rep = 0;
            for (int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];
                String k = getK(p1, p2);
                if (k == null) {
                    rep++;
                } else {
                    if (!count.containsKey(k)) {
                        count.put(k, 1);
                    }
                    count.put(k, count.get(k) + 1);
                }
            }
            if (rep + 1 > max)
                max = rep + 1;
            for (String key : count.keySet()) {
                int size = count.get(key) + rep;
                if (size > max) {
                    max = size;
                }
            }
        }
        return max;
    }
    
    private String getK(Point p1, Point p2) {
        if (p1.x == p2.x && p1.y == p2.y) {
            return null;
        } else if (p1.x == p2.x) {
            return "v";
        } else if (p1.y == p2.y) {
            return "0";
        } else {
            return String.valueOf((p1.y - p2.y) * 1. / (p1.x - p2.x));
        }
    }
}