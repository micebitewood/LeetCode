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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0)
            return head;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode node = temp;
        for (int i = 0; i < n; i++) {
            if (node == null)
                return head;
            node = node.next;
        }
        ListNode first = temp;
        while (node.next != null) {
            node = node.next;
            first = first.next;
        }
        first.next = first.next.next;
        return temp.next;
    }
}