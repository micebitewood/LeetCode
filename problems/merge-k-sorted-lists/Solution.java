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
        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        int count = lists.size();
        boolean[] isNull = new boolean[count];
        while (count > 0) {
            int min = Integer.MAX_VALUE;
            int j = -1;
            for (int i = 0; i < lists.size(); i++) {
                ListNode node = lists.get(i);
                if (node == null) {
                    if (!isNull[i])
                        count--;
                    isNull[i] = true;
                    continue;
                } else if (node.val < min) {
                    j = i;
                    min = node.val;
                }
            }
            if (j == -1)
                break;
            ListNode node = lists.get(j);
            cur.next = node;
            cur = node;
            lists.set(j, node.next);
        }
        return temp.next;
    }
}