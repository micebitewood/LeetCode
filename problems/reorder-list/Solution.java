/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        reverse(slow);
        combine(head, slow);
    }
    private void reverse(ListNode head) {
        if (head.next == null)
            return;
        ListNode tail = head.next;
        while (tail.next != null) {
            ListNode temp = tail.next;
            tail.next = temp.next;
            temp.next = head.next;
            head.next = temp;
        }
    }
    private void combine(ListNode head, ListNode tail) {
        while (tail.next != null) {
            ListNode temp = tail.next;
            tail.next = temp.next;
            temp.next = head.next;
            head.next = temp;
            head = temp.next;
        }
    }
}