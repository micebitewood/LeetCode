public class Solution {
    public int maxProfit(int[] prices) {
        List<Integer> list = new ArrayList<Integer>();
        boolean up = false;
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            if (up) {
                if (prices[i] < prices[i - 1]) {
                    up = false;
                    list.add(prices[i - 1]);
                }
            } else {
                if (prices[i] > prices[i - 1]) {
                    up = true;
                    list.add(prices[i - 1]);
                }
            }
        }
        if (up && prices[length - 1] >= prices[length - 2])
            list.add(prices[length - 1]);
        length = list.size();
        int max = 0;
        for (int k = 1; k < length; k += 2) {
            for (int i = 0; i + k < length; i += 2) {
                int profit = list.get(i + k) - list.get(i);
                if (profit > max)
                    max = profit;
            }
        }
        return max;
    }
}