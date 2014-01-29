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
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode tail = tempHead;
        while (tail.next != null) {
            ListNode next = tail.next;
            ListNode ptr = tempHead;
            while(ptr != tail) {
                if (ptr.next.val < next.val) {
                    ptr = ptr.next;
                } else {
                    break;
                }
            }
            if (ptr != tail) {
                tail.next = next.next;
                next.next = ptr.next;
                ptr.next = next;
            } else {
                tail = tail.next;
            }
        }
        return tempHead.next;
    }
}