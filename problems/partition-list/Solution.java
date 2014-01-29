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
    public ListNode partition(ListNode head, int x) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode first = tempHead;
        ListNode second = head;
        while (first.next != null && first.next.val < x) {
            first = first.next;
        }
        if (first.next == null)
            return head;
        second = first.next;
        while (second.next != null && second.next.val >= x) {
            second = second.next;
        }
        if (second.next == null)
            return head;
        while (second.next != null) {
            if (second.next.val < x) {
                ListNode next = second.next;
                second.next = next.next;
                next.next = first.next;
                first.next = next;
                first = next;
            } else {
                second = second.next;
            }
        }
        return tempHead.next;
    }
}