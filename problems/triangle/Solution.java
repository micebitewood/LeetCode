public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int size = triangle.size();
        Deque<Integer> extra = new LinkedList<Integer>();
        extra.add(triangle.get(0).get(0));
        for (int i = 1; i < size; i++) {
            ArrayList<Integer> list = triangle.get(i);
            int last = extra.poll();
            extra.add(list.get(0) + last);
            extra.add(list.get(1) + last);
            for (int j = 2; j < list.size(); j++) {
                int first = list.get(j - 1);
                int second = list.get(j);
                int cur = extra.poll();
                if (cur < last) {
                    extra.pollLast();
                    extra.add(first + cur);
                }
                extra.add(second + cur);
                last = cur;
            }
        }
        int min = Integer.MAX_VALUE;
        while (extra.size() > 0) {
            int val = extra.poll();
            if (min > val)
                min = val;
        }
        return min;
    }
}