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
    public int sumNumbers(TreeNode root) {
        int res = 0;
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                res += node.val;
                continue;
            }
            if (node.left != null) {
                node.left.val += node.val * 10;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.val += node.val * 10;
                queue.add(node.right);
            }
        }
        return res;
    }
}