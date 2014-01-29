public class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append("*");
            sb.append(c);
        }
        sb.append("*");
        String t = sb.toString();
        int[] ind = new int[2];
        for (int i = 1; i < t.length() - 1; i++) {
            int len = 1;
            while (i - len >= 0 && i + len < t.length() && t.charAt(i - len) == t.charAt(i + len)) {
                len++;
            }
            len--;
            if (2 * len > ind[1] - ind[0]) {
                ind[0] = i - len;
                ind[1] = i + len;
            }
        }
        return getRes(t, ind[0], ind[1]);
    }
    private String getRes(String t, int left, int right) {
        StringBuilder sb = new StringBuilder();
        for (int i = left + 1; i < right; i += 2) {
            sb.append(t.charAt(i));
        }
        return sb.toString();
    }
}