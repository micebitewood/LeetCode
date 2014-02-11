public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        getRes(num, 0, new ArrayDeque<Integer>());
        return res;
    }
    
    private void getRes(int[] num, int start, Deque<Integer> deque) {
        for (int i = start; i < num.length; i++) {
            if (i != start && num[i - 1] == num[i]) {
                continue;
            }
            deque.addLast(num[i]);
            res.add(new ArrayList<Integer>(deque));
            getRes(num, i + 1, deque);
            deque.pollLast();
        }
    }
}