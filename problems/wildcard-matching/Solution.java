public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.matches("\\*+"))
            return true;
        if (s.isEmpty() && p.isEmpty())
            return true;
        int p1 = 0;
        int p2 = 0;
        int start = -1;
        int p11 = -1;
        while (p1 < s.length()) {
            char c1 = getChar(s, p1);
            char c2 = getChar(p, p2);
            if (c1 == c2 || c2 == '?') {
                p1++;
                p2++;
            } else if (c2 == '*') {
                start = ++p2;
                p11 = p1;
            } else if (start != -1){
                p2 = start;
                p1 = ++p11;
            } else {
                return false;
            }
        }
        if (p1 != s.length() || !p.substring(p2).matches("\\**")) {
            return false;
        }
        return true;
    }
    
    private char getChar(String s, int i) {
        if (i >= s.length())
            return '\n';
        return s.charAt(i);
    }
}