public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                left[i] = left[i - 1];
            } else {
                left[i] = Math.max(left[i - 1], prices[i] - min);
            }
        }
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
                right[i] = right[i + 1];
            } else {
                right[i] = Math.max(right[i + 1], max - prices[i]);
            }
        }
        max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, left[i] + right[i]);
        }
        return max;
    }
}