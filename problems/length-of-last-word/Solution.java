public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.isEmpty())
            return 0;
        int ind = s.lastIndexOf(" ");
        if (ind == -1)
            return s.length();
        else
            return s.length() - ind - 1;
    }
}