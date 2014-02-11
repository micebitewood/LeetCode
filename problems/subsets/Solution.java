public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        res = new ArrayList<ArrayList<Integer>>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        res.add(new ArrayList<Integer>(stack));
        if (S.length == 0)
            return res;
        Arrays.sort(S);
        getRes(S, 0, stack);
        return res;
    }
    
    private void getRes(int[] s, int start, Deque<Integer> stack) {
        for (int i = start; i < s.length; i++) {
            stack.addLast(s[i]);
            res.add(new ArrayList<Integer>(stack));
            getRes(s, i + 1, stack);
            stack.pollLast();
        }
    }
}