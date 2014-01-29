/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        mergeSort(tempHead, null);
        return tempHead.next;
    }
    
    private void mergeSort(ListNode head, ListNode tail) {
        if (head.next.next == tail)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        mergeSort(head, slow.next);
        mergeSort(slow, tail);
        merge(head, slow, tail);
    }
    
    private void merge(ListNode head, ListNode mid, ListNode tail) {
        while (mid.next != tail && mid != head) {
            if (head.next.val > mid.next.val) {
                ListNode temp = mid.next;
                mid.next = temp.next;
                temp.next = head.next;
                head.next = temp;
            }
            head = head.next;
        }
    }
}