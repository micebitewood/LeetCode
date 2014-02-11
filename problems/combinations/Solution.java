public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        res = new ArrayList<ArrayList<Integer>>();
        getRes(1, n, k, new ArrayDeque<Integer>());
        return res;
    }
    
    private void getRes(int l, int r, int count, Deque<Integer> deque) {
        if (count == 0) {
            res.add(new ArrayList<Integer>(deque));
            return;
        }
        for (int i = l; i <= r - count + 1; i++) {
            deque.addLast(i);
            getRes(i + 1, r, count - 1, deque);
            deque.pollLast();
        }
    }
}