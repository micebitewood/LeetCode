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
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode first = temp;
        ListNode second = temp;
        while (second.next != null && second.next.val < x) {
            second = second.next;
        }
        if (second.next == null)
            return head;
        first = second;
        while (second.next != null) {
            if (second.next.val >= x) {
                second = second.next;
            } else {
                ListNode node = second.next;
                second.next = node.next;
                node.next = first.next;
                first.next = node;
                first = node;
            }
        }
        return temp.next;
    }
}