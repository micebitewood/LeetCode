public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null)
            return true;
        if (s == null || p == null)
            return false;
        if (s.isEmpty() && p.isEmpty())
            return true;
        if (s.isEmpty() && p.length() > 1 && p.charAt(1) == '*')
            return isMatch(s, p.substring(2));
        if (s.isEmpty() || p.isEmpty())
            return false;
        char c1 = s.charAt(0);
        char c2 = p.charAt(0);
        char c3 = p.length() > 1 ? p.charAt(1) : ' ';
        if (c3 == '*') {
            if (c2 == '.') {
                for (int i = 1; i <= s.length(); i++) {
                    if (isMatch(s.substring(i), p.substring(2)))
                        return true;
                }
            } else if (c1 == c2) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == c1) {
                        if (isMatch(s.substring(i + 1), p.substring(2)))
                            return true;
                    } else
                        break;
                }
            }
            return isMatch(s, p.substring(2));
        } else if (c2 == '.' || c1 == c2) {
            return isMatch(s.substring(1), p.substring(1));
        } else
            return false;
    }
}