public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        if (n == 0)
            return res;
        int m = 4;
        res.add(1);
        while (m <= Math.pow(2, n)) {
            int last = res.size() - 1;
            for (int i = last; i >= 0; i--) {
                int num = ((m - 1) & res.get(i));
                num |= (m / 2);
                res.add(num);
            }
            m *= 2;
        }
        return res;
    }
}