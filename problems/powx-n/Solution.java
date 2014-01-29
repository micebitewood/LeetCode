public class Solution {
    public double pow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 1)
            return 1;
        boolean neg = false;
        if (n < 0) {
            neg = true;
            n = -n;
        }
        double res = 1;
        while (n > 0) {
            if ((n & 1) == 1)
                res *= x;
            x *= x;
            n = (n >> 1);
        }
        if (neg)
            res = 1 / res;
        return res;
    }
}