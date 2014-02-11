public class Solution {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        if (m == 0)
            return b;
        if (n == 0)
            return a;
        int p1 = m - 1;
        int p2 = n - 1;
        String res = "";
        boolean cf = false;
        while (p1 >= 0 || p2 >= 0) {
            char c1 = '0';
            char c2 = '0';
            if (p1 >= 0) {
                c1 = a.charAt(p1);
                p1--;
            }
            if (p2 >= 0) {
                c2 = b.charAt(p2);
                p2--;
            }
            if (cf) {
                if (c1 == '1' && c2 == '1') {
                    res = "1" + res;
                } else if (c1 == '1' || c2 == '1') {
                    res = "0" + res;
                } else {
                    res = "1" + res;
                    cf = false;
                }
            } else {
                if (c1 == '1' && c2 == '1') {
                    res = "0" + res;
                    cf = true;
                } else if (c1 == '1' || c2 == '1') {
                    res = "1" + res;
                } else {
                    res = "0" + res;
                }
            }
        }
        if (cf)
            res = "1" + res;
        return res;
    }
}