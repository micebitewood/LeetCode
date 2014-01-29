public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int res = 0;
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            candies[i] = 1;
            if (ratings[i] > ratings[i - 1])
                candies[i] += candies[i - 1];
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i])
                candies[i - 1] = candies[i] + 1;
        }
        for (int i = 0; i < ratings.length; i++) {
            res += candies[i];
        }
        return res;
    }
}