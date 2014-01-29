public class Solution {
    public int maxArea(int[] height) {
        if (height == null)
            return 0;
        int length = height.length;
        if (length <= 1)
            return 0;
        int max = 0;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int val = Math.min(height[left], height[right]);
            int area = val * (right - left);
            if (area > max)
                max = area;
            if (height[left] > height[right]) {
                int ptr = right;
                while (ptr > left && height[ptr] <= height[right]) {
                    ptr--;
                }
                right = ptr;
            } else {
                int ptr = left;
                while (ptr < right && height[ptr] <= height[left])
                    ptr++;
                left = ptr;
            }
        }
        return max;
    }
}