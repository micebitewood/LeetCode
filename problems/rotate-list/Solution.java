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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode node = head;
        int i = 0;
        while (i <= n - 1) {
            if (node.next == null) {
                if (i == n - 1)
                    return head;
                else {
                    n -= i + 1;
                    node = head;
                    i = 0;
                }
            } else {
                node = node.next;
                i++;
            }
        }
        ListNode first = head;
        while (node.next != null) {
            first = first.next;
            node = node.next;
        }
        node.next = head;
        ListNode temp = first.next;
        first.next = null;
        return temp;
    }
}