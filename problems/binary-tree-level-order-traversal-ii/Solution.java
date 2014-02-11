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
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        Deque<ArrayList<Integer>> deque = new ArrayDeque<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode nil = new TreeNode(0);
        queue.add(nil);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (queue.size() > 1) {
            TreeNode node = queue.poll();
            if (node == nil) {
                deque.push(list);
                list = new ArrayList<Integer>();
                queue.add(nil);
            } else {
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        deque.push(list);
        res.addAll(deque);
        return res;
    }
}