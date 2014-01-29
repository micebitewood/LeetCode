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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;
        ListNode[] heads = new ListNode[lists.size()];
        int i = 0;
        for (ListNode list: lists) {
            heads[i] = new ListNode(0);
            heads[i++].next = list;
        }
        ListNode temp = new ListNode(0);
        ListNode node = temp;
        while (true) {
            ListNode n = null;
            for (ListNode head : heads) {
                if (head.next == null)
                    continue;
                else if (n == null || head.next.val < n.next.val)
                    n = head;
            }
            if (n == null)
                break;
            node.next = n.next;
            node = node.next;
            n.next = node.next;
        }
        return temp.next;
    }
}