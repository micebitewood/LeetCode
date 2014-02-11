public class Solution {
    public int divide(int dividend, int divisor) {
        long divid = dividend;
        long divis = divisor;
        boolean neg = false;
        if (divid < 0 && divis < 0) {
            divid = -divid;
            divis = -divis;
        } else if (divid < 0 || divis < 0) {
            divid = Math.abs(divid);
            divis = Math.abs(divis);
            neg = true;
        }
        List<Long> list = new ArrayList<Long>();
        while (divis <= divid) {
            list.add(divis);
            divis += divis;
        }
        int res = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (divid >= list.get(i)) {
                divid -= list.get(i);
                res |= (1 << i);
            }
        }
        if (neg)
            res = -res;
        return res;
    }
}