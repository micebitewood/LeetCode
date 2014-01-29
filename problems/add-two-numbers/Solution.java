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
        ListNode head = new ListNode(0);
        ListNode node = head;
        boolean cf = false;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val;
            if (cf) {
                val++;
                cf = false;
            }
            if (val >= 10) {
                cf = true;
                val -= 10;
            }
            ListNode newNode = new ListNode(val);
            node.next = newNode;
            node = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val;
            if (cf) {
                val++;
                cf = false;
            }
            if (val >= 10) {
                cf = true;
                val -= 10;
            }
            ListNode newNode = new ListNode(val);
            node.next = newNode;
            node = newNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val;
            if (cf) {
                val++;
                cf = false;
            }
            if (val >= 10) {
                cf = true;
                val -= 10;
            }
            ListNode newNode = new ListNode(val);
            node.next = newNode;
            node = newNode;
            l2 = l2.next;
        }
        if (cf)
            node.next = new ListNode(1);
        return head.next;
    }
}