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
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode cur = temp;
        while (cur.next != null && cur.next.next != null) {
            ListNode node = cur.next;
            while (node.next != null && node.next.val == cur.next.val) {
                node = node.next;
            }
            if (node != cur.next) {
                cur.next = node.next;
            } else
                cur = node;
        }
        return temp.next;
    }
}