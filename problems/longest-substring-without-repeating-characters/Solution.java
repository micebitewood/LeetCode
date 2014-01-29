public class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] visited = new boolean[256];
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!visited[c]) {
                visited[c] = true;
            } else {
                int count = i - start;
                if (count > max)
                    max = count;
                for (int j = start; j < i; j++) {
                    char ch = s.charAt(j);
                    if (ch != c) {
                        visited[ch] = false;
                    } else {
                        start = j + 1;
                        break;
                    }
                }
            }
        }
        if (s.length() - start > max)
            max = s.length() - start;
        return max;
    }
}