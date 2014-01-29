public class Solution {
    ArrayList<ArrayList<String>> res;
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        res = new ArrayList<ArrayList<String>>();
        Queue<Node> queue = new LinkedList<Node>();
        
        Set<String> visited = new HashSet<String>();
        visited.add(start);
        
        Map<String, Set<String>> neighbors = new HashMap<String, Set<String>>();
        
        queue.add(new Node(null, start));
        Node nil = new Node(null, null);
        queue.add(nil);
        
        boolean isCompleted = false;
        while (true) {
            Node node = queue.poll();
            if (node == nil) {
                if (isCompleted)
                    break;
                if (queue.size() == 0)
                    break;
                queue.add(nil);
            } else {
                String word = node.str;
                int length = word.length();
                visited.add(word);
                if (neighbors.containsKey(word)) {
                    Set<String> set = neighbors.get(word);
                    for (String str : set) {
                        if (str.equals(end)) {
                            add(end, node);
                        } else if (!visited.contains(str))
                            queue.add(new Node(node, str));
                    }
                } else {
                    Set<String> set = new HashSet<String>();
                    char[] ch = word.toCharArray();
                    for (int i = 0; i < length; i++) {
                        char original = ch[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == original)
                                continue;
                            ch[i] = c;
                            String str = new String(ch);
                            if (str.equals(end)) {
                                set.add(str);
                                add(end, node);
                                isCompleted = true;
                            } else if (!isCompleted && !visited.contains(str) && dict.contains(str)) {
                                queue.add(new Node(node, str));
                                set.add(str);
                            }
                            ch[i] = original;
                        }
                    }
                    neighbors.put(word, set);
                }
            }
        }
        return res;
    }
    
    class Node {
        Node previous;
        String str;
        
        public Node(Node p, String s) {
            this.previous = p;
            this.str = s;
        }
    }
    
    private void add(String end, Node node) {
        
        Deque<String> list = new LinkedList<String>();
        list.push(end);
        Node t = node;
        while (t != null) {
            list.push(t.str);
            t = t.previous;
        }
        res.add(new ArrayList<String>(list));
    }
}
