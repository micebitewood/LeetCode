public class Solution {
    ArrayList<String> res;
    
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        res = new ArrayList<String>();
        boolean[] dp = new boolean[s.length()];
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dict.contains(s.substring(i)))
                dp[i] = true;
            else {
                for (int j = i + 1; j < dp.length; j++) {
                    if (dp[j] && dict.contains(s.substring(i, j))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        stack.push(0);
        while (stack.size() > 1) {
            int last = stack.pop();
            int start = stack.peek();
            int i = last + 1;
            if (sb.length() != 0 && start < last) {
                sb.delete(sb.length() - last + start - 1, sb.length());
            }
            for (; i < dp.length; i++) {
                if (dp[i] && dict.contains(s.substring(start, i))) {
                    stack.push(i);
                    stack.push(i);
                    sb.append(s.substring(start, i) + " ");
                    break;
                }
            }
            if (i == dp.length && dict.contains(s.substring(start))) {
                sb.append(s.substring(start));
                res.add(sb.toString());
                sb.delete(sb.length() - dp.length + start, sb.length());
            }
        }
        return res;
    }
}
