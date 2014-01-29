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
    public void recoverTree(TreeNode root) {
        recover(root);
    }
    
    private boolean recover(TreeNode root) {
        if (root == null)
            return false;
        TreeNode max = isAll(root, true);
        TreeNode min = isAll(root, false);
        if (max == root && min == root) {
            boolean left = recover(root.left);
            if (left)
                return true;
            return recover(root.right);
        } else {
            int temp = max.val;
            max.val = min.val;
            min.val = temp;
            return true;
        }
    }
    
    private TreeNode isAll(TreeNode root, boolean isSmaller) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode max = root;
        TreeNode min = root;
        if (isSmaller && root.left != null) {
            queue.add(root.left);
        } else if (isSmaller)
            return root;
        else if (!isSmaller && root.right != null) {
            queue.add(root.right);
        } else
            return root;
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (isSmaller && node.val > max.val) {
                max = node;
            } else if (!isSmaller && node.val < min.val) {
                min = node;
            }
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        if (isSmaller)
            return max;
        else
            return min;
    }
}