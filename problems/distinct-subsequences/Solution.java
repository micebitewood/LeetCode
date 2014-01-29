public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || S.isEmpty())
            return 0;
        if (T == null || T.isEmpty())
            return 1;
        int size1 = S.length();//3
        int size2 = T.length();
        if (size2 > size1)
            return 0;
        int[][] dp = new int[size2 + 1][size1 + 1];
        for (int i = 1; i <= size2; i++)
            dp[i][0] = 0;
        for (int j = 0; j <= size1; j++)
            dp[0][j] = 1;
        for (int i = 1; i <= size2; i++) {
            for (int j = 1; j <= size1; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[size2][size1];
    }
}