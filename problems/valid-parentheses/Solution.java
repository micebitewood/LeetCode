public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.size() == 0)
                    return false;
                char c1 = stack.pop();
                if (c1 != '(')
                    return false;
            } else if (c == '}') {
                if (stack.size() == 0)
                    return false;
                char c1 = stack.pop();
                if (c1 != '{')
                    return false;
            } else if (c == ']') {
                if (stack.size() == 0)
                    return false;
                char c1 = stack.pop();
                if (c1 != '[')
                    return false;
            } else
                stack.push(c);
        }
        if (stack.size() != 0)
            return false;
        return true;
    }
}