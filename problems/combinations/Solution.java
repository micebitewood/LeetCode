public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (n < k)
            return res;
        if (k == 0)
            return res;
        getRes(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void getRes(int n, int count, int start, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
        if (count == 0)
            res.add(new ArrayList<Integer>(list));
        else if (n - start + 1 < count)
            return;
        else {
            for (int i = start; i <= n; i++) {
                list.add(i);
                getRes(n, count - 1, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}