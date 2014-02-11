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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        boolean cf = false;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int val = val1 + val2;
            if (cf) {
                val++;
                cf = false;
            }
            if (val > 9) {
                cf = true;
                val -= 10;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        if (cf) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}