public class Solution {
    public int maxProfit(int[] prices) {
        List<Integer> list = new ArrayList<Integer>();
        boolean up = false;
        for (int i = 1; i < prices.length; i++) {
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
        if (up && prices[prices.length - 1] >= prices[prices.length - 2])
            list.add(prices[prices.length - 1]);
        if (list.size() == 2)
            return list.get(1) - list.get(0);
        if (list.size() == 4)
            return list.get(3) + list.get(1) - list.get(2) - list.get(0);
        int[][] best = new int[list.size()][list.size()];
        for (int i = 0; i < list.size(); i += 2) {
            best[i][i + 1] = list.get(i + 1) - list.get(i);
        }
        for (int length = 3; length < list.size(); length += 2) {
            for (int i = 0; i < list.size(); i += 2) {
                if (i + length < list.size()) {
                    best[i][i + length] = list.get(i + length) - list.get(i);
                    best[i][i + length] = Math.max(best[i][i + length], best[i][i + length - 2]);
                    best[i][i + length] = Math.max(best[i][i + length], best[i + 2][i + length]);
                }
            }
        }
        int max = 0;
        for (int i = 1; i < list.size() - 1; i += 2) {
            if (max < best[0][i] + best[i + 1][list.size() - 1])
                max = best[0][i] + best[i + 1][list.size() - 1];
        }
        return max;
    }
}