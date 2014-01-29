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
        if (root == null)
            return true;
        int val = differ(root);
        if (val >= 0)
            return true;
        return false;
    }
    
    private int differ(TreeNode root) {
        if (root.left == null && root.right == null)
            return 1;
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = differ(root.left);
            if (left == -1)
                return -1;
        }
        if (root.right != null) {
            right = differ(root.right);
            if (right == -1)
                return -1;
        }
        if (left == right)
            return left + 1;
        else if (left > right) {
            if (left > right + 1)
                return -1;
            return left + 1;
        } else {
            if (left < right - 1)
                return -1;
            return right + 1;
        }
    }
}