public class Solution {
    ArrayList<ArrayList<Integer>> res;
    ArrayList<Integer> list;
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        res = new ArrayList<ArrayList<Integer>>();
        list = new ArrayList<Integer>();
        for (int n : num) {
            list.add(n);
        }
        permute(0);
        return res;
    }
    
    private void permute(int start) {
        if (start == list.size() - 1) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        int origin = list.get(start);
        for (int i = start; i < list.size(); i++) {
            int num = list.get(i);
            list.set(start, num);
            list.set(i, origin);
            permute(start + 1);
            list.set(start, origin);
            list.set(i, num);
        }
    }
}