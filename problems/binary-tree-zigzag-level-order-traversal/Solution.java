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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode nil = new TreeNode(0);
        queue.add(nil);
        boolean left = true;
        Deque<Integer> list = new LinkedList<Integer>();
        while (queue.size() > 1) {
            TreeNode node = queue.poll();
            if (node == nil) {
                res.add(new ArrayList<Integer>(list));
                list.clear();
                queue.add(nil);
                left = !left;
            } else {
                if (left) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        res.add(new ArrayList<Integer>(list));
        return res;
    }
}