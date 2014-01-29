public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null)
            return 0;
        int length = height.length;
        if (length == 0)
            return 0;
        int[][] counts = new int[length][2];
        counts[length - 1][0] = 0;
        for (int i = length - 2; i >= 0; i--) {
            if (height[i] <= height[i + 1])
                counts[i][0] = counts[i + 1][0] + 1;
            else
                counts[i][0] = 0;
        }
        counts[0][1] = 0;
        for (int i = 1; i < length; i++) {
            if (height[i] <= height[i - 1])
                counts[i][1] = counts[i - 1][1] + 1;
            else
                counts[i][1] = 0;
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            int left = i - 1;
            int right = i + 1;
            int val = height[i];
            if (val > 0) {
                while (true) {
                    boolean b1 = false;
                    boolean b2 = false;
                    if (left >= 0 && height[left] >= val) {
                        if (counts[left][1] != 0)
                            left -= counts[left][1];
                        left--;
                        b1 = true;
                    }
                    if (right < length && height[right] >= val) {
                        if (counts[right][0] != 0)
                            right += counts[right][0];
                        right++;
                        b2 = true;
                    }
                    if (!b1 && !b2)
                        break;
                }
                int area = val * (right - left - 1);
                if (area > max)
                    max = area;
            }
        }
        return max;
    }
}