public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3)
            return false;
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= l1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1))
                dp[i][0] = dp[i - 1][0];
        }
        for (int j = 1; j <= l2; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1))
                dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int k = i + j - 1;
                if (s1.charAt(i - 1) == s3.charAt(k) && dp[i - 1][j])
                    dp[i][j] = true;
                if (s2.charAt(j - 1) == s3.charAt(k) && dp[i][j - 1])
                    dp[i][j] = true;
            }
        }
        return dp[l1][l2];
    }
}