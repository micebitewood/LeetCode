public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int level = 2;
        if (start.equals(end))
            return 1;
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        visited.add(start);
        String nil = "";
        queue.add(nil);
        while (queue.size() > 1) {
            String str = queue.poll();
            if (str == nil) {
                level++;
                queue.add(nil);
            } else {
                char[] arr = str.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String word = new String(arr);
                        if (word.equals(end)) {
                            return level;
                        }
                        else if (!visited.contains(word) && dict.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                    arr[i] = original;
                }
            }
        }
        return 0;
    }
    
}