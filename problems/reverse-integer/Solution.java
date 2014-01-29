public class Solution {
    public int reverse(int x) {
        if (x == 0)
            return 0;
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = -x;
        }
        int res = 0;
        while (x > 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        if (neg)
            res = -res;
        return res;
    }
}