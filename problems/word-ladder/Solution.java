public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        String nil = "";
        queue.add(nil);
        int level = 0;
        Set<String> visited = new HashSet<String>();
        visited.add(start);
        while (true) {
            String str = queue.poll();
            if (str == nil) {
                level++;
                if (queue.size() == 0)
                    return 0;
                queue.add(nil);
            } else {
                for (int i = 0; i < str.length(); i++) {
                    String first = str.substring(0, i);
                    String second = str.substring(i + 1);
                    for (char c = 'a'; c <= 'z'; c++) {
                        String s = first + String.valueOf(c) + second;
                        if (s.equals(end))
                            return level + 2;
                        if (!visited.contains(s) && dict.contains(s)) {
                            queue.add(s);
                            visited.add(s);
                        }
                    }
                }
            }
        }
    }
}