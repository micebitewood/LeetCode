public class LRUCache {
    private Map<Integer, ListNode> table = new HashMap<Integer, ListNode>();
    private int capacity;
    ListNode head;
    ListNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(0, 0);
        tail = head;
    }
    
    public int get(int key) {
        if (!table.containsKey(key))
            return -1;
        ListNode temp = table.get(key);
        if (temp.next == tail)
            return tail.val;
        tail.next = temp.next;
        table.put(key, tail);
        tail = tail.next;
        temp.next = tail.next;
        table.put(temp.next.key, temp);
        tail.next = null;
        return tail.val;
    }
    
    public void set(int key, int value) {
        get(key);
        if (table.containsKey(key)) {
            tail.val = value;
            return;
        }
        if (table.size() == capacity && !table.containsKey(key)) {
            table.remove(head.next.key);
            head = head.next;
        }
        tail.next = new ListNode(key, value);
        table.put(key, tail);
        tail = tail.next;
    }
    
    private class ListNode {
        int key;
        int val;
        ListNode next;
        
        private ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}