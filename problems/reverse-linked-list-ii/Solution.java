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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode first = tempHead;
        for (int i = 1; i < m; i++) {
            first = first.next;
        }
        ListNode last = first.next;
        for (int i = m; i < n; i++) {
            ListNode next = last.next;
            last.next = next.next;
            next.next = first.next;
            first.next = next;
        }
        return tempHead.next;
    }
}