public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        res = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0)
            return res;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        res.add(new ArrayList<Integer>(queue));
        for (int i = 1; i < numRows; i++) {
            int last = queue.poll();
            queue.add(1);
            for (int j = 1; j < i; j++) {
                int cur = queue.poll();
                queue.add(last + cur);
                last = cur;
            }
            queue.add(1);
            res.add(new ArrayList<Integer>(queue));
        }
        return res;
    }
}