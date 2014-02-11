public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        boolean[] visited = new boolean[256];
        int max = 0;
        for (int cur = 0; cur < s.length(); cur++) {
            char c = s.charAt(cur);
            if (visited[c]) {
                max = Math.max(max, cur - start);
                while (start < cur) {
                    char c2 = s.charAt(start++);
                    if (c2 == c) {
                        break;
                    }
                    visited[c2] = false;
                }
            } else {
                visited[c] = true;
            }
        }
        max = Math.max(max, s.length() - start);
        return max;
    }
}