public class Solution {
    public int atoi(String str) {
        if (str == null)
            return 0;
        str = str.trim();
        if (str.isEmpty())
            return 0;
        char ch = str.charAt(0);
        boolean neg = false;
        if (ch == '+' || ch == '-') {
            if (ch == '-')
                neg = true;
            str = str.substring(1);
        }
        int i = 0;
        int res = 0;
        while (i < str.length()) {
            ch = str.charAt(i);
            if (ch <= '9' && ch >= '0') {
                if (!neg && res > Integer.MAX_VALUE / 10) {
                    return Integer.MAX_VALUE;
                } else if (neg && res < Integer.MIN_VALUE / 10) {
                    return Integer.MIN_VALUE;
                }
                res *= 10;
                if (!neg) {
                    if (res + 7 == Integer.MAX_VALUE && ch > '7')
                        return Integer.MAX_VALUE;
                    res += ch - '0';
                } else {
                    if (res - 8 == Integer.MIN_VALUE && ch > '8')
                        return Integer.MIN_VALUE;
                    res -= ch - '0';
                }
            } else {
                break;
            }
            i++;
        }
        return res;
    }
}