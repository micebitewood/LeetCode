public class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int res = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                stack.pop();
                int j = stack.isEmpty() ? start : stack.peek();
                res = Math.max(i - j, res);
            } else {
                start = i;
            }
        }
        return res;
    }
}