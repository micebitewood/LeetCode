public class Solution {
    ArrayList<ArrayList<String>> res;
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        res = new ArrayList<ArrayList<String>>();
        
        Queue<ListNode> queue = new LinkedList<ListNode>();
        queue.add(new ListNode(start, null));
        ListNode nil = new ListNode("", null);
        queue.add(nil);
        
        Map<String, Set<String>> neighbors = new HashMap<String, Set<String>>();
        Set<String> visited = new HashSet<String>();
        
        boolean completed = false;
        
        while (queue.size() > 1) {
            ListNode node = queue.poll();
            if (node == nil) {
                if (completed)
                    break;
                queue.add(nil);
            } else {
                String word = node.str;
                visited.add(word);
                if (neighbors.containsKey(word)) {
                    Set<String> set = neighbors.get(word);
                    for (String s : set) {
                        if (s.equals(end)) {
                            add(end, node);
                            break;
                        } else if (!completed && !visited.contains(s)){
                            queue.add(new ListNode(s, node));
                        }
                    }
                } else {
                    char[] arr = word.toCharArray();
                    Set<String> set = new HashSet<String>();
                    neighbors.put(word, set);
                    for (int i = 0; i < arr.length; i++) {
                        char origin = arr[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == origin)
                                continue;
                            arr[i] = c;
                            String newStr = new String(arr);
                            if (newStr.equals(end)) {
                                add(end, node);
                                completed = true;
                                set.add(newStr);
                            } else if (!completed && !visited.contains(newStr) && dict.contains(newStr)) {
                                queue.add(new ListNode(newStr, node));
                                set.add(newStr);
                            }
                        }
                        arr[i] = origin;
                    }
                }
            }
        }
        return res;
    }
    
    class ListNode {
        String str;
        ListNode prev;
        ListNode(String str, ListNode prev) {
            this.str = str;
            this.prev = prev;
        }
    }
    
    private void add(String end, ListNode node) {
        Deque<String> stack = new ArrayDeque<String>();
        stack.push(end);
        while (node != null) {
            stack.push(node.str);
            node = node.prev;
        }
        res.add(new ArrayList<String>(stack));
    }
}
