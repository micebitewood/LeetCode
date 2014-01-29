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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode nil = new TreeNode(0);
        queue.add(nil);
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (queue.size() > 1) {
            TreeNode node = queue.poll();
            if (node == nil) {
                temp.add(list);
                list = new ArrayList<Integer>();
                queue.add(nil);
            } else {
                list.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        temp.add(list);
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
        return res;
    }
}