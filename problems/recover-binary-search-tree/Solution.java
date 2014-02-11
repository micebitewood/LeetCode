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
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        recover(root, null);
        if (first == null)
            return;
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }
    
    private TreeNode recover(TreeNode root, TreeNode prev) {
        if (root == null)
            return prev;
        prev = recover(root.left, prev);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        return recover(root.right, root);
    }
}