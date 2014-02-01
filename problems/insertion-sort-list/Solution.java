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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tHead = new ListNode(0);
        tHead.next = head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val >= cur.val) {
                cur = cur.next;
            } else {
                ListNode temp = tHead;
                while (temp.next.val < cur.next.val) {
                    temp = temp.next;
                }
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = temp.next;
                temp.next = next;
            }
        }
        return tHead.next;
    }
}