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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.addLast(root.val);
        root.val = sum - root.val;
        traverse(root, stack, res);
        return res;
    }
    private void traverse(TreeNode root, Deque<Integer> stack, ArrayList<ArrayList<Integer>> res) {
        if (root.left == null && root.right == null) {
            if (root.val == 0)
                res.add(new ArrayList<Integer>(stack));
            return;
        }
        if (root.left != null) {
            stack.addLast(root.left.val);
            root.left.val = root.val - root.left.val;
            traverse(root.left, stack, res);
            stack.removeLast();
        }
        if (root.right != null) {
            stack.addLast(root.right.val);
            root.right.val = root.val - root.right.val;
            traverse(root.right, stack, res);
            stack.removeLast();
        }
    }
}