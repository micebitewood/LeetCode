public class Solution {
    ArrayList<ArrayList<Integer>> res;
    Deque<Integer> deque;
    Set<Integer> visited;
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        res = new ArrayList<ArrayList<Integer>>();
        deque = new ArrayDeque<Integer>();
        visited = new HashSet<Integer>();
        Arrays.sort(num);
        getPermute(num);
        return res;
    }
    
    private void getPermute(int[] num) {
        if (deque.size() == num.length) {
            res.add(new ArrayList<Integer>(deque));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visited.contains(i) || (i > 0 && !visited.contains(i - 1) && num[i] == num[i - 1]))
                continue;
            deque.addLast(num[i]);
            visited.add(i);
            getPermute(num);
            deque.pollLast();
            visited.remove(i);
        }
    }
    
}