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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isValidBST(root, new TreeNode(root.val), new TreeNode(root.val));
    }
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        min.val = root.val;
        max.val = root.val;
        if (root.left == null && root.right == null) {
            return true;
        }
        int minVal = root.val;
        int maxVal = root.val;
        if (root.left != null) {
            boolean left = isValidBST(root.left, min, max);
            if (!left || max.val >= root.val) {
                return false;
            }
            if (min.val < minVal)
                minVal = min.val;
        }
        if (root.right != null) {
            boolean right = isValidBST(root.right, min, max);
            if (!right || min.val <= root.val) {
                return false;
            }
            if (max.val > maxVal)
                maxVal = max.val;
        }
        max.val = maxVal;
        min.val = minVal;
        return true;
    }
}