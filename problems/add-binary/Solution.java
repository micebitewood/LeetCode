public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty())
            return b;
        if (b == null || b.isEmpty())
            return a;
        int i = a.length() - 1;
        int j = b.length() - 1;
        Deque<Character> stack = new LinkedList<Character>();
        boolean cf = false;
        while (i >= 0 && j >= 0) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(j);
            if (c1 == c2) {
                if (cf) {
                    stack.push('1');
                    cf = false;
                } else
                    stack.push('0');
                if (c1 == '1')
                    cf = true;
            } else {
                if (cf) {
                    stack.push('0');
                } else
                    stack.push('1');
            }
            i--;
            j--;
        }
        while (i >= 0) {
            char c = a.charAt(i);
            if (cf && c == '1')
                stack.push('0');
            else if (cf) {
                stack.push('1');
                cf = false;
            }
            else
                stack.push(c);
            i--;
        }
        while (j >= 0) {
            char c = b.charAt(j);
            if (cf && c == '1')
                stack.push('0');
            else if (cf) {
                stack.push('1');
                cf = false;
            }
            else
                stack.push(c);
            j--;
        }
        if (cf)
            stack.push('1');
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}