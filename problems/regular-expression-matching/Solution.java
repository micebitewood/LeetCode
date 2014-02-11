public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
        if (p.length() > 1 && p.charAt(1) == '*') {
            String pp = p.substring(2);
            if (s.isEmpty()) {
                return isMatch(s, pp);
            } else if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') {
                return isMatch(s, pp);
            } else {
                while (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                    if (isMatch(s, pp)) {
                        return true;
                    }
                    s = s.substring(1);
                }
                return isMatch(s, pp);
            }
        } else {
            if (s.isEmpty()) {
                return false;
            }
            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }
}