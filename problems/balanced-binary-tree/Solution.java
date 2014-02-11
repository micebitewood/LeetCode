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
    public boolean isBalanced(TreeNode root) {
        if (getLevel(root) == -1)
            return false;
        return true;
    }
    
    private int getLevel(TreeNode root) {
        if (root == null)
            return 0;
        int l = getLevel(root.left);
        int r = getLevel(root.right);
        if (l == -1 || r == -1)
            return -1;
        if (Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }
}