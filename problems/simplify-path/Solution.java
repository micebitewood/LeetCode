public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<String>();
        if (path.charAt(path.length() - 1) != '/') {
            path = path + "/";
        }
        while (!path.isEmpty()) {
            int ind = path.indexOf("/");
            if (ind == 0) {
                path = path.substring(1);
            } else {
                String str = path.substring(0, ind);
                path = path.substring(ind + 1);
                if (str.equals("..")) {
                    if (stack.size() > 0) {
                        stack.pop();
                    }
                } else if (!str.equals(".")) {
                    stack.push(str);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.size() == 0) {
            return "/";
        }
        while (stack.size() > 0) {
            sb.append("/" + stack.pollLast());
        }
        return sb.toString();
    }
}