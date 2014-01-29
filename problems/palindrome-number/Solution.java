public class Solution {
    public boolean isPalindrome(int x) {
        //if (x == Integer.MIN_VALUE)
        //return false;
        if (x < 0)
            return false;
        long base = 1;
        while (x >= base * 10)
            base *= 10;
        int l = (int) base;
        while (x > 9) {
            int u = x / l;
            int d = x % 10;
            if (u != d)
                return false;
            x %= l;
            x /= 10;
            l /= 100;
        }
        return true;
    }
}