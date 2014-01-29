public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        permute(num, 0, num.length, res);
        return res;
    }
    
    private void permute(int[] num, int l, int r, ArrayList<ArrayList<Integer>> res) {
        if (l == r - 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int n : num)
                list.add(n);
            res.add(list);
        } else {
            for (int i = l; i < r; i++) {
                int t = num[i];
                num[i] = num[l];
                num[l] = t;
                permute(num, l + 1, r, res);
                t = num[i];
                num[i] = num[l];
                num[l] = t;
            }
        }
    }
}