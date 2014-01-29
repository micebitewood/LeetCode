/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1)
            return head;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode first = temp;
        ListNode last = temp;
        while (true) {
            for (int i = 0; i < k; i++) {
                last = last.next;
                if (last == null)
                    return temp.next;
            }
            first = reverse(first, last);
            last = first;
        }
    }
    
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode res = head.next;
        while (head.next != tail) {
            ListNode node = head.next;
            head.next = node.next;
            node.next = tail.next;
            tail.next = node;
        }
        return res;
    }
}