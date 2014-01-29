/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        TreeNode root = toBST(tempHead, null);
        return root;
    }
    
    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head.next == tail)
            return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.next.val);
        root.left = toBST(head, slow.next);
        root.right = toBST(slow.next, tail);
        return root;
    }
}