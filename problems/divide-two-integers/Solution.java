public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        boolean neg = false;
        long n1 = dividend;
        long n2 = divisor;
        if (n1 < 0 || n2 < 0) {
            if (n1 > 0 || n2 > 0)
                neg = true;
            n1 = Math.abs(n1);
            n2 = Math.abs(n2);
        }
        long base = n2;
        long count = 1;
        while (base <= n1) {
            base = (base << 1);
            count = (count << 1);
        }
        base = (base >> 1);
        count = (count >> 1);
        int res = 0;
        while (base >= n2) {
            if (n1 >= base) {
                res += count;
                n1 -= base;
            }
            base = (base >> 1);
            count = (count >> 1);
        }
        if (neg)
            res = -res;
        return res;
    }
}