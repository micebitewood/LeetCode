public class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(i);
            else {
                if (stack.size() == 0)
                    start = i + 1;
                else {
                    stack.pop();
                    if (stack.isEmpty())
                        max = Math.max(max, i - start + 1);
                    else
                        max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}