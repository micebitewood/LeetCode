public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (S == null)
            return res;
        Arrays.sort(S);
        for (int i = 0; i <= S.length; i++)
            add(S, 0, i, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void add(int[] S, int start, int count, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
        if (count == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < S.length; i++) {
            list.add(S[i]);
            add(S, i + 1, count - 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}