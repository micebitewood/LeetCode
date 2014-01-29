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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == node.val) {
                ListNode next = node.next;
                while (next.next != null && next.next.val == node.val)
                    next = next.next;
                node.next = next.next;
            } else
                node = node.next;
        }
        return head;
    }
}