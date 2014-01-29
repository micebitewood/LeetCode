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
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode node = temp;
        while (node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                ListNode next = node.next.next;
                while (next.next != null && next.next.val == node.next.val)
                    next = next.next;
                node.next = next.next;
            } else
                node = node.next;
        }
        return temp.next;
    }
}