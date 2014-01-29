public class Solution {
    public String simplifyPath(String path) {
        if (path == null)
            return null;
        if (path.isEmpty())
            return "";
        Deque<String> stack = new LinkedList<String>();
        while (!path.isEmpty()) {
            int ind = path.indexOf("/");
            if (ind == -1) {
                if (path.equals("."))
                    break;
                else if (path.equals(".."))
                    stack.pop();
                else
                    stack.push(path);
                if (stack.size() == 0)
                    stack.push("/");
                break;
            }
            String str = path.substring(0, ind + 1);
            path = path.substring(ind + 1);
            if (str.equals("../")) {
                stack.pop();
                if (stack.size() == 0)
                    stack.push("/");
            } else if (str.equals("/") && stack.size() == 0) {
                stack.push(str);
            } else if (str.equals("/"))
                continue;
            else if (str.equals("./"))
                continue;
            else {
                stack.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pollLast());
        }
        String str = sb.toString();
        if (str.charAt(str.length() - 1) == '/' && str.length() > 1)
            str = str.substring(0, str.length() - 1);
        return str;
    }
}