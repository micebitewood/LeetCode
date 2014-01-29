public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.isEmpty()) {
            if (p.isEmpty() || p.matches("\\**"))
                return true;
            else
                return false;
        }
        if (p.isEmpty())
            return false;
        if (p.matches("\\**"))
            return true;
        int i1 = 0;
        int i2 = 0;
        int star = -1;
        int last = 0;
        while (i1 < s.length()) {
            char c1 = s.charAt(i1);
            char c2 = '\0';
            if (i2 < p.length()) {
                c2 = p.charAt(i2);
            }
            if (c1 == c2 || c2 == '?') {
                i1++;
                i2++;
            } else if (c2 == '*') {
                star = i2;
                last = i1;
                i2++;
            } else if (star != -1) {
                i2 = star + 1;
                last++;
                i1 = last;
            } else
                return false;
        }
        while (i2 < p.length()) {
            if (p.charAt(i2) != '*')
                return false;
            i2++;
        }
        return true;
    }
}