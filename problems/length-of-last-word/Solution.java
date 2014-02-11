public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.isEmpty())
            return 0;
        int p = s.length() - 1;
        while (p >= 0 && s.charAt(p) == ' ')
            p--;
        if (p == -1)
            return 0;
        int end = p;
        while (p >= 0 && s.charAt(p) != ' ')
            p--;
        return end - p;
    }
}