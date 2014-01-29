public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.isEmpty()) {
            if (s2.equals(s3))
                return true;
            return false;
        }
        if (s2 == null || s2.isEmpty()) {
            if (s1.equals(s3))
                return true;
            return false;
        }
        int l1 = s1.length();
        int l2 = s2.length();
        if (s3 == null || s3.length() != l1 + l2) {
            return false;
        }
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= l1; i++) {
            int ind = i - 1;
            if (s3.charAt(ind) == s1.charAt(i - 1) && dp[i - 1][0])
                dp[i][0] = true;
        }
        for (int j = 1; j <= l2; j++) {
            int ind = j - 1;
            if (s3.charAt(ind) == s2.charAt(j - 1) && dp[0][j - 1])
                dp[0][j] = true;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                char c = s3.charAt(i + j - 1);
                if (c == s1.charAt(i - 1) && dp[i - 1][j])
                    dp[i][j] = true;
                if (c == s2.charAt(j - 1) && dp[i][j - 1])
                    dp[i][j] = true;
            }
        }
        return dp[l1][l2];
    }
}