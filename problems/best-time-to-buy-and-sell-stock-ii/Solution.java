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
        int res = 0;
        for (int i = 0; i < length; i += 2) {
            res += list.get(i + 1) - list.get(i);
        }
        return res;
    }
}