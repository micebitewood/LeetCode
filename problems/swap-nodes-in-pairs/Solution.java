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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode node = temp;
        while (node.next != null && node.next.next != null) {
            ListNode n = node.next;
            ListNode t = n.next;
            node.next = t;
            n.next = t.next;
            t.next = n;
            node = n;
        }
        return temp.next;
    }
}