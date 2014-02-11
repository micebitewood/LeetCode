public class Solution {
    ArrayList<Integer> res;
    public ArrayList<Integer> grayCode(int n) {
        res = new ArrayList<Integer>();
        res.add(0);
        if (n == 0)
            return res;
        res.add(1);
        for (int i = 1; i < n; i++) {
            int base = (1 << i);
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(base | res.get(j));
            }
        }
        return res;
    }
}