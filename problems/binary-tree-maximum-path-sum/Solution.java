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
    public int maxPathSum(TreeNode root) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if (root.left == null && root.right == null)
            return root.val;
        int max = 0;
        int res = root.val;
        if (root.left != null) {
            left = maxPathSum(root.left);
            if (max < root.left.val)
                max = root.left.val;
            if (res < root.val + root.left.val)
                res = root.val + root.left.val;
            if (res < left)
                res = left;
        }
        if (root.right != null) {
            right = maxPathSum(root.right);
            if (max < root.right.val)
                max = root.right.val;
            if (res < root.val + root.right.val)
                res = root.val + root.right.val;
            if (res < right)
                res = right;
        }
        if (root.left != null && root.right != null && res < root.val + root.left.val + root.right.val)
            res = root.val + root.left.val + root.right.val;
        root.val += max;
        return res;
    }
}