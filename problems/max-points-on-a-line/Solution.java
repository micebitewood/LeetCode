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
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            Point start = points[i];
            Map<String, Integer> table = new HashMap<String, Integer>();
            int vertical = 0;
            int rep = 0;
            for (int j = i + 1; j < points.length; j++) {
                Point end = points[j];
                if (end.x == start.x && end.y == start.y) {
                    rep++;
                    continue;
                }
                String k = getK(start, end);
                if (k == null) {
                    vertical++;
                    continue;
                }
                if (!table.containsKey(k)) {
                    table.put(k, 0);
                }
                table.put(k, table.get(k) + 1);
            }
            for (String key: table.keySet()) {
                if (table.get(key) + rep + 1 > max) {
                    max = table.get(key) + rep + 1;
                }
            }
            if (vertical + rep + 1 > max)
                max = vertical + rep + 1;
        }
        return max;
    }
    
    private String getK(Point p1, Point p2) {
        if (p1.x == p2.x)
            return null;
        if (p1.y == p2.y)
            return "0";
        double k = (p1.y - p2.y) * 1. / (p1.x - p2.x);
        return String.valueOf(k);
    }
}