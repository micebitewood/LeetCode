public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            queue.add(1);
            int last = queue.poll();
            for (int j = 1; j < i; j++) {
                int cur = queue.poll();
                queue.add(cur + last);
                last = cur;
            }
            queue.add(1);
        }
        ArrayList<Integer> res = new ArrayList<Integer>(queue);
        return res;
    }
}