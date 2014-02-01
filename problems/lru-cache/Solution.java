public class LRUCache {
    ListNode head, tail;
    int capacity;
    Map<Integer, ListNode> posTable = new HashMap<Integer, ListNode>();
    int size;
    
    public LRUCache(int capacity) {
        head = new ListNode(0, 0);
        tail = head;
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {
        if (!posTable.containsKey(key)) {
            return -1;
        }
        refresh(key);
        return tail.val;
    }
    
    public void set(int key, int value) {
        if (posTable.containsKey(key)) {
            refresh(key);
            tail.val = value;
        } else {
            if (capacity == 0)
                return;
            if (size == capacity) {
                int k = head.next.key;
                posTable.remove(k);
                head = head.next;
                insert(new ListNode(key, value));
            } else {
                insert(new ListNode(key, value));
                size++;
            }
        }
    }
    
    private void insert(ListNode node) {
        tail.next = node;
        posTable.put(node.key, tail);
        tail = node;
    }
    
    private void refresh(int key) {
        ListNode prev = posTable.get(key);
        ListNode node = prev.next;
        if (node != tail) {
            posTable.put(node.next.key, prev);
            prev.next = node.next;
            node.next = null;
            tail.next = node;
            posTable.put(key, tail);
            tail = node;
        }
    }
    
    class ListNode {
        int key, val;
        ListNode next;
        ListNode(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
}