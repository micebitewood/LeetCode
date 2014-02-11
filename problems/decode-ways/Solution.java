public class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0')
            return 0;
        int l = s.length();
        int[] dp = new int[l + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= l; i++) {
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            int n = Integer.parseInt(s.substring(i - 2, i));
            if (n >= 10 && n <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[l];
    }
}