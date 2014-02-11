public class Solution {
    public int largestRectangleArea(int[] height) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int max = 0;
        int i = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[i] > height[stack.peek()]) {
                stack.push(i);
                i++;
            }
            else {
                int j = stack.pop();
                max = Math.max(max, height[j] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            max = Math.max(max, height[j] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        }
        return max;
    }
}