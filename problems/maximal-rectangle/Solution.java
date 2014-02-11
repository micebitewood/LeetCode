public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        if (n == 0)
            return 0;
        int[][] dp = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (i == 0) ? 1 : dp[i - 1][j] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        for (int i = m - 1; i >= 0; i--) {
            max = Math.max(max, getMax(dp[i]));
        }
        return max;
    }
    
    private int getMax(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int i = 0;
        int max = 0;
        while (i < arr.length) {
            if (stack.isEmpty() || arr[i] > arr[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int j = stack.pop();
                max = Math.max(max, arr[j] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return max;
    }
}