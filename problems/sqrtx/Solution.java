public class Solution {
    public int sqrt(int x) {
        if (x <= 1)
            return x;
        long res = x;
        while (res * res > x) {
            res = (res * res + x) / (2 * res);
        }
        return (int)res;
    }
}