public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0')
            return 0;
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= length; i++) {
            if (s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i - 2, i)) <= 26)
                dp[i] += dp[i - 2];
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
        }
        return dp[length];
    }
}